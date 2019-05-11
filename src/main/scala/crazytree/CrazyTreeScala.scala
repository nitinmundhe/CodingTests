package crazytree

import java.io.{BufferedReader, BufferedWriter, InputStreamReader, OutputStreamWriter}

class CrazyTreeScala {


  def buildCrzyTree(L:Int) ={

  }

  def getLevelArray(): Unit ={

  }
  def query(N:Int,X:Int,Y:Int):Int={
    return 0
  }

  @throws[Exception]
  def main(args: Array[String]): Unit = {
    val in = new BufferedReader(new InputStreamReader(System.in))
    val out = new BufferedWriter(new OutputStreamWriter(System.out))
    val line1 = in.readLine.split(" ")
    val L = line1(0).toInt
    var Q = line1(1).toInt
    //val crazyTree = new CrazyTreeOne(L)
    while ( {
      {
        Q -= 1; Q + 1
      } > 0
    }) {
      val query = in.readLine.split(" ")
      val N = query(0).toInt
      val X = query(1).toInt
      val Y = query(2).toInt
      //val res = crazyTree.query(N, X, Y)
      //out.write(res + "\n")
    }
    out.flush()
  }
}
