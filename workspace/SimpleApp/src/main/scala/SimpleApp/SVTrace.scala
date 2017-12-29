package SimpleApp

import java.text.SimpleDateFormat

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

class SVTrace {
  def ConsumingTime(fileName: String, top: Int): Unit = {

    val ss = SparkSession.builder()
                  .master("local")
                  .appName("Trace time")
                  .getOrCreate()

    import ss.implicits._

    val dateFormat = new SimpleDateFormat("hh:mm:ss MMM dd")

    val traceFile =
      ss.read.textFile(fileName).map((line) => {
        val timeStamps = line.split(" ").take(3)
        val microSeconds = timeStamps(0).split("\\.")(1)
        timeStamps(0) = timeStamps(0).split("\\.")(0)

        val epochSeconds =
            dateFormat.parse(timeStamps.mkString(" ")).toInstant.getEpochSecond
        val epochTime = epochSeconds.toDouble + microSeconds.toDouble / 1000000
        (epochTime, line)
      }).toDF("time", "operation")

    val timeSpec = Window.orderBy("time")
    val timeDiff = traceFile.withColumn("pretime", lag(traceFile("time"), 1, 0).over(timeSpec))
    timeDiff.show()
    timeDiff.map((row) => {
        var diff : Long = 0
        row match {
          case Row(a: Double, b: String, 0) => diff = 0
          case Row(a: Double, b: String, c: Double) => {
            diff = ((a - c) * 1000000).toLong
            println(a + "-" + c + " = " + diff)
          }

        }
        (row.getAs[Double]("time"), row.getAs[String]("operation"), diff)
    }).toDF("time", "operation", "diff(micro)").orderBy(desc("diff(micro)")).show(top)
  }
}
