package crazytree

/***
  * Input
  *
  * First line of input contains two space separated integers L and Q, where L is number of levels in the crazy tree and Q is total number of queries. Each of the next Q lines contains three space separated integers N, X and Y.
  *
  * Output
  *
  * Output the value of S(N, X, Y) % M in single line for each test case.
  *
  * Constraints
  *
  * 1 <= L <= 21
  * 1 <= Q <= min(106, (2L - 1) (2L + 4) / 6), where min(a, b) is minimum of a and b
  * 1 <= N <= L
  * 1 <= X <= 2(L - 1)
  * X <= Y <= 2(L - 1)
  *
  */
object Test {
  /*
  var input = scala.io.StdIn.readLine()
  val L:Int = input.split(" ")(0).toInt
  val Q:Int = input.split(" ")(1).toInt
  var N:Int = 0
  var X:Int = 0
  var Y:Int = 0
  require(1 <= L && L <= 21 )
  require(1 <= Q && Q <= 21 )
  */
  def main(args:Array[String]): Unit ={
    val tree :BinaryTree = new BinaryTree()
    tree .root = Option(new Node(1))
    tree .root.get.left =Option(new Node(2))
    tree .root.get.right =Option(new Node(3))
  }

}