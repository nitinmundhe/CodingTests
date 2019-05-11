package dimondinheritence

trait A{
  def display(){ println("From dimondinheritence.A.display")  }
}
trait B extends A{
  override def display() { println("From dimondinheritence.B.display") }
}
trait C extends A{
  override def display() { println("From dimondinheritence.C.display") }
}
trait D extends A{
  override def display() { println("From dimondinheritence.D.display") }
}

class E extends B with C with D{ }

object ScalaDiamonProblemTest extends App {
  val e = new E
  e display
}