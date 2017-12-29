import SimpleApp.SVTrace
import org.scalatest._

class SVTraceSpec extends FlatSpec {
  "SVTrace app " should "run" in {
    val trace = new SVTrace

    //trace.ConsumingTime("src/main/resources/trerate.trc", 10)
    trace.ConsumingTime("/sda3/trerate6.80.trc", 10)
    println("PageRank App Test Passed")
  }

}
