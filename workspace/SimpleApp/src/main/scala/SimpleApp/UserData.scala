package SimpleApp

import java.io.{BufferedWriter, File, FileWriter, PrintWriter}

import scala.io._
import scala.util.Random

class UserData {
  def GenerateUsers(fileName: String, range: Int): Unit = {
    val fileHandle = new BufferedWriter(new FileWriter(new File(fileName)))

    val output = for (i <- 1 to range) yield i.toString + "," + RandomString(5 + Random.nextInt(20))
    fileHandle.write(output.mkString("\n"))
    fileHandle.close()
  }

  def RandomString(length: Int): String = {
    Random.alphanumeric.take(length).mkString("")
  }

  def GenerateFollowers(fileName: String, range: Int): Unit = {
    val fileHandle = new BufferedWriter(new FileWriter(new File(fileName)))
    for (i <- 1 to range) {
      val rows = (1 to range).map( x => (1+Random.nextInt(range)).toString + " " + (1+Random.nextInt(range)).toString )
      fileHandle.write(rows.mkString("\n"))
    }

    fileHandle.close()
  }
}
