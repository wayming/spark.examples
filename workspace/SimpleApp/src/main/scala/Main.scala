package SimpleApp

object Main {

  def main(args: Array[String]) {
    println("Hello World")
    val dataGenerator = new UserData
    dataGenerator.GenerateUsers(args(0), 100)
    dataGenerator.GenerateFollowers(args(1), 100)

    //dataGenerator.GenerateUsers("src/main/resources/users1.txt", 100)
    //dataGenerator.GenerateFollowers("src/main/resources/followers1.txt", 100)
  }
}