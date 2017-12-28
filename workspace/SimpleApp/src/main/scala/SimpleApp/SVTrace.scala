package SimpleApp

import java.text.SimpleDateFormat

import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}
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
        val epochTime = epochSeconds.toDouble * 1000000 + microSeconds.toDouble
        (epochTime, line)
      }).toDF("time", "operation")

    println(traceFile.show())
  }
}
