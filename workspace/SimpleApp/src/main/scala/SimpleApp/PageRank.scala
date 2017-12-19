package SimpleApp

import org.apache.spark.graphx.GraphLoader
import org.apache.spark.{SparkConf, SparkContext}

class PageRank {
  def execute(args: Array[String]): Unit = {
    //Create a SparkContext to initialize Spark
    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("Word Count")
    val sc = new SparkContext(conf)


    val graph = GraphLoader.edgeListFile(sc, "src/main/resources/followers.txt")
    val ranks = graph.pageRank(0.0001).vertices
    println(ranks.collect.mkString("\n"))
    val users = sc.textFile("src/main/resources/users.txt").map({
      line =>
        val fields = line.split(",")
        (fields(0).toLong, fields(1))
    })
    val ranksByUsername = users.join(ranks).map({
      case (_, (username, rank)) => (username, rank)
    })
    println(ranksByUsername.collect.mkString("\n"))

    sc.stop()
  }

}
