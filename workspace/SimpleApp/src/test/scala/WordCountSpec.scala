import SimpleApp.WordCount
import org.scalatest._

class WordCountSpec extends FlatSpec {
  "SimpleApp.WordCount app " should "run" in {
    val count = new WordCount
    count.execute()
    println("SimpleApp.WordCount App Test Passed")
  }
}
