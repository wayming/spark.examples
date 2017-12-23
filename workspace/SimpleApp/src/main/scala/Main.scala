import SimpleApp.UserData

object Main {

  def main(args: Array[String]) {
    println("Hello World")
    val dataGenerator = new UserData
    dataGenerator.GenerateUsers("src/main/resources/users1.txt", 5000)
    dataGenerator.GenerateFollowers("src/main/resources/followers1.txt", 5000)
  }
}