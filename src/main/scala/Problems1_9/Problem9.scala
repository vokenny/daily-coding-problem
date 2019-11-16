package Problems1_9

import scala.annotation.tailrec

object Problem9 extends App {

  // HARD
  // This problem was asked by Airbnb.
  //
  // Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
  //
  // For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
  //
  // Follow-up: Can you do this in O(N) time and constant space?

  val numList: List[Int] = 2 :: 4 :: 6 :: 2 :: 5 :: Nil

  // Take max from list
  // Remove adjacent values
  // Take max from new list, and sum with previous max
  // Repeat
  // Return summed values

  def largestSumNonAdj(list: List[Int]): Int = {
    @tailrec
    def largestSumNonAdjTailRec(remList: List[(Int, Int)], result: Int): Int = {
      remList match {
        case Nil => result
        case _ =>
          val max = remList.max
          largestSumNonAdjTailRec(remList.filter(e => e._2 != max._2 && e._2 != max._2 + 1 && e._2 != max._2 - 1), max._1 + result)
      }
    }

    largestSumNonAdjTailRec(list.zipWithIndex, 0)
  }

  println(largestSumNonAdj(numList))
}
