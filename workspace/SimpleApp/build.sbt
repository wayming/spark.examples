name := "SimpleApp"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies ++= {
  val sparkVer = "2.2.1"
  Seq(
    "org.apache.spark" %% "spark-core" % sparkVer % "provided" withSources(),
    "org.apache.spark" %% "spark-graphx" % sparkVer % "provided" withSources(),
    "org.apache.spark" %% "spark-sql" % sparkVer % "provided" withSources()
  )
}

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.4" % "test"

