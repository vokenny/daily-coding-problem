package medium

import scala.annotation.tailrec

object Problem30 extends App {

  // 2020-11-02

  // MEDIUM
  // This problem was asked by Facebook.
  //
  // You are given an array of non-negative integers that represents a two-dimensional elevation map where each
  // element is unit-width wall and the integer is the height. Suppose it will rain and all spots between two walls get filled up.
  //
  // Compute how many units of water remain trapped on the map in O(N) time and O(1) space.
  //
  // For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.
  //
  // Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second,
  // and 3 in the fourth index (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.
  //
  //      |             |
  //      |             |
  // |  | | = |  | +  | |
  // |  | |   |  |    | |
  // |_||_|   |_||    |_|

  // Go through list
  // Take first value
  // Look for next value >= first value, whilst saving all intermediate values
  // calcVolInSubContainer
  // Repeat with last value of first container, and remaining list

  val testContainer = List(3, 0, 1, 3, 0, 5)

  def calcTotalVolume(container: List[Int]): Int = {
    @tailrec
    def accumulateVolumes(remainingContainer: List[Int], currentContainer: List[Int], result: Int): Int = {
      remainingContainer match {
        case Nil => result
        case h :: tail =>
          if (currentContainer.isEmpty) accumulateVolumes(tail, List(h), result)
          else if (h >= currentContainer.max) {
            val vol: Int = calcVolInSubContainer(currentContainer :+ h)
            accumulateVolumes(remainingContainer, Nil, result + vol)
          }
          else accumulateVolumes(tail, currentContainer :+ h, result)
      }
    }

    accumulateVolumes(container, Nil, 0)
  }

  def calcVolInSubContainer(container: List[Int]): Int = {
    val leftWall: Int = container.head
    val rightWall: Int = container.last
    val maxDepth: Int = (leftWall :: rightWall :: Nil).min
    val middle: List[Int] = container.tail.init

    middle.foldLeft(0)((vol, height) => (maxDepth - height) + vol)
  }

  println(calcTotalVolume(testContainer))

}
