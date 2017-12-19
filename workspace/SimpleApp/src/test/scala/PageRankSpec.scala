import SimpleApp.PageRank
import org.scalatest._

class PageRankSpec extends FlatSpec {
  "PageRank app " should "run" in {
    val rank = new PageRank
    rank.execute(Array[String]())
    println("PageRank App Test Passed")
  }

}
