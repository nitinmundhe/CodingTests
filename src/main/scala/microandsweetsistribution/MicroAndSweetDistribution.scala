package microandsweetsistribution

import scala.io.StdIn._

object MicroAndSweetDistribution {
  def main(args: Array[String]): Unit = {
    val testCases = readInt()
    for (testcase <- 1 to testCases) {
      val line1, line2, line3 = readLine()
      val dimensions: Array[Int] = line1.split(" ").map(_.toInt)
      val startFrom: Array[Int] = line2.split(" ").map(_.toInt)
      val myLocation: Array[Int] = line3.split(" ").map(_.toInt)
      solveTestCase(dimensions, startFrom, myLocation)
    }
  }

  /** *
    *
    * @param dimensions
    * @param startFrom
    * @param myLocation
    */
  def solveTestCase(dimensions: Array[Int], startFrom: Array[Int], myLocation: Array[Int]): Unit = {
    var curRow = startFrom(0) - 1
    var curCol = startFrom(1) - 1
    val sweetsReceived = Array.ofDim[Int](dimensions(0), dimensions(1))
    sweetsReceived(curRow)(curCol) = 1
    //println("Start From " + (curRow+1) + " " + (curCol+1))

    var flag = true
    var count = 1
    while (flag && count <= dimensions(0)*dimensions(1)) {
      count += 1
      val nextStudent: (Int, Int, String) = getNextStudent(curRow, curCol, sweetsReceived, dimensions)
      nextStudent match {
        case (x: Int, y: Int,_) if x == myLocation(0)-1 && y == myLocation(1)-1 => {
          curRow = nextStudent._1
          curCol = nextStudent._2
          sweetsReceived(curRow)(curCol) = 1
          println(getNextStudent(curRow, curCol, sweetsReceived, dimensions)._3);
          flag = false
        }
        case _ => {
          curRow = nextStudent._1
          curCol = nextStudent._2
          sweetsReceived(curRow)(curCol) = 1
          //println("Start From " + (nextStudent._1 +1) + " " + (nextStudent._2+1) + " " + nextStudent._3)
        }
      }
    }
  }

  /** *
    * If there is a student in the Right who has not received sweet, then pass it right (x,y+1).
    * If there is a student in the Left who has not received sweet, then pass it left (x,y-1).
    * If there is a student in the Front who has not received sweet, then pass it front (x-1,y).
    * If there is a student in the Back who has not received sweet, then pass it back (x+1,y).
    * Shout Over, meaning that all students have received sweets.
    *
    * @return
    */
  def getNextStudent(currentRow: Int, currentCol: Int, sweetsReceived: Array[Array[Int]], dimensions: Array[Int]): (Int, Int, String) = {
    val tuple = (currentRow, currentCol)
    tuple match {
      case (x, y) if y + 1 < dimensions(1) && sweetsReceived(x)(y + 1) == 0 => (x, y + 1, "Right") //Right
      case (x, y) if y - 1 >= 0 && sweetsReceived(x)(y - 1) == 0 => (x, y - 1, "Left") //Left
      case (x, y) if x - 1 >= 0 && sweetsReceived(x - 1)(y) == 0 => (x - 1, y, "Front") //Front
      case (x, y) if x + 1 < dimensions(1) && sweetsReceived(x + 1)(y) == 0 => (x + 1, y, "Back") //Back
      case _ => (0, 0, "Over")
    }
  }
}
