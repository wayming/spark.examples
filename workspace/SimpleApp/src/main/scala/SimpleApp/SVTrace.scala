package SimpleApp

import java.text.SimpleDateFormat

import org.apache.spark.{SparkConf, SparkContext}

class SVTrace {
  def ConsumingTime(fileName: String, top: Int): Unit = {
    val conf = new SparkConf()
    conf.setAppName("ConsumingTime")
    conf.setMaster("local")

    val sc = new SparkContext(conf)

    val traceFile = sc.textFile(fileName)

    println(traceFile.count())

    val dateFormat = new SimpleDateFormat("hh:mm:ss MMM dd")
    val result =
      traceFile.map((line) => {
      val timeStamps = line.split(" ").take(3)
      val microSeconds = timeStamps(0).split("\\.")(1)
      timeStamps(0) = timeStamps(0).split("\\.")(0)

      val epochSeconds =
        dateFormat.parse(timeStamps.mkString(" ")).toInstant.getEpochSecond
      val epochTime = epochSeconds.toDouble * 1000000 + microSeconds.toDouble
      (epochTime, line)
    }).

    println(result)
  }
}
