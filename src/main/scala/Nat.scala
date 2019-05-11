package week4

//Peano Numbers
abstract class Nat {
  def isZero:Boolean
  def predecessor : Nat
  def scusessor = new Succ(this)
  def +(that:Nat):Nat
  def -(that:Nat):Nat
}

class Zero extends Nat{
  def isZero:Boolean = true
  def predecessor : Nat = throw new Error("0.predecessor")
  def +(that:Nat):Nat = that
  def -(that:Nat):Nat = if(that.isZero) this else throw new Error("Negative Number")
}
class Succ(n:Nat) extends Nat{
  def isZero:Boolean = false
  def +(that:Nat):Nat = new Succ(n + that)
  def predecessor : Nat = throw new Error("0.predecessor")
  def -(that:Nat):Nat = if (that.isZero) that else n - that.predecessor
}
