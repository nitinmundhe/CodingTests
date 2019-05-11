package test

import scala.io.StdIn._

object TestCode {
  def main(args:Array[String])={
    val n = readInt()
    val a = readLine().split(" ")
    val b = readLine().split(" ")
    var c = new Array[Int](n)
    for( i <- 0 until n ){
      c(i) = a(i).toInt+b(i).toInt
    }
    println(c.mkString(" "))
  }
}