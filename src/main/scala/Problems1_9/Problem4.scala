package Problems1_9

import scala.annotation.tailrec

object Problem4 extends App {

  // HARD
  // This problem was asked by Stripe.
  //
  // Given an array of integers, find the first missing positive integer in linear time and constant space.
  // In other words, find the lowest positive integer that does not exist in the array.
  // The array can contain duplicates and negative numbers as well.
  //
  // For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
  //
  // You can modify the input array in-place.

  val numbers1 = List(3, 4, -1, 1)
  val numbers2 = List(1, 2, 0)

  // Filter out negative values and zero
  // Sort in ascending order
  // Check first two values if they succeed each other
  // if yes, move along one index
  // if no, return first positive missing value (e.g. 3 in 2 & 5)

  def findFirstMissingPosInt(numList: List[Int]): Int = {
    @tailrec
    def findFirstMissingPosIntTailRec(yetToSee: List[Int]): Int = {
      yetToSee match {
        case Nil => throw new IllegalArgumentException
        case h :: Nil => h + 1
        case h :: m :: tail => if (h + 1 == m) findFirstMissingPosIntTailRec(m :: tail) else h + 1
      }
    }

    val posIntList = numList.filter(e => e.sign >= 0).sorted

    if (numList.isEmpty) throw new IllegalArgumentException
    else if (posIntList.isEmpty) findFirstMissingPosIntTailRec(List(0))
    else findFirstMissingPosIntTailRec(posIntList)
  }

  println(findFirstMissingPosInt(numbers1))
  println(findFirstMissingPosInt(numbers2))
}
