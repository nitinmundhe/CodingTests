package inheritence

class Teacher {
  val designation = "Teacher"
  val collegeName = "Beginnersbook"

  def does(): Unit = {
    System.out.println("Teaching")
  }
}

object PhysicsTeacher {
  def main(args: Array[String]): Unit = {
    val obj = new PhysicsTeacher
    System.out.println(obj.collegeName)
    System.out.println(obj.designation)
    System.out.println(obj.mainSubject)
    obj.does()
  }
}

class PhysicsTeacher extends Teacher {
  val mainSubject = "Physics"
}