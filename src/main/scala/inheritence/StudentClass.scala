package inheritence

class AddressScala(var streetNum: Int, var city: String, var state: String, var country: String) {
}

object StudentClassScala {
  def main(args: Array[String]): Unit = {
    val ad = new AddressScala(55, "Agra", "UP", "India")
    val obj = new StudentClassScala(123, "Chaitanya", ad)
    System.out.println(obj.rollNum)
    System.out.println(obj.studentName)
    System.out.println(obj.studentAddr.streetNum)
    System.out.println(obj.studentAddr.city)
    System.out.println(obj.studentAddr.state)
    System.out.println(obj.studentAddr.country)
  }
}

class StudentClassScala(var rollNum: Int, var studentName: String, //Creating HAS-A relationship with Address class
                   var studentAddr: AddressScala) {
}