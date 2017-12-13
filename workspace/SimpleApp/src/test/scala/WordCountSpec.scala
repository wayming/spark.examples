import main.scala.WordCount
import org.scalatest._

class WordCountSpec extends FlatSpec {
  "WordCount app " should "run" in {
    val count = new WordCount
    count.execute()
    println("WordCount App Test Passed")
  }
}
