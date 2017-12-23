import SimpleApp.SVTrace
import org.scalatest._

class SVTraceSpec extends FlatSpec {
  "SVTrace app " should "run" in {
    val rank = new SVTrace

    rank.ConsumingTime("src/main/resources/trerate.trc", 10)

    println("PageRank App Test Passed")
  }

}
