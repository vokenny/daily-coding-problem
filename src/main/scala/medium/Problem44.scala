package medium

import scala.annotation.tailrec

object Problem44 extends App {

  // 2020-11-02

  // MEDIUM

  // This problem was asked by Google.
  //
  // We can determine how "out of order" an array A is by counting the number of inversions it has.
  // Two elements A[i] and A[j] form an inversion if A[i] > A[j] but i < j. That is, a smaller element appears after a larger element.
  //
  // Given an array, count the number of inversions it has. Do this faster than O(N^2) time.
  //
  // You may assume each element in the array is distinct.
  //
  // For example, a sorted list has zero inversions.
  // The array [2, 4, 1, 3, 5] has three inversions: (2, 1), (4, 1), and (4, 3).
  // The array [5, 4, 3, 2, 1] has ten inversions: every distinct pair forms an inversion.

  // Able to discard once checked against everything to the right
  // Compare numerical values against head
  // Increase count for how ever many are less than head
  // Repeat

  val inversion1: List[Int] = List(1, 2, 3, 4, 5) // 0
  val inversion2: List[Int] = List(2, 4, 1, 3, 5) // 3
  val inversion3: List[Int] = List(5, 4, 3, 2, 1) // 10
  val inversion4: List[Int] = List(1, 2, 9, 4, 6, 5, 7, 8, 3) // 12

  def calcInversion(sample: List[Int]): Int = {
    (for (check <- sample) yield {
      val remainingSample: List[Int] = sample.dropWhile(_ != check).tail
      remainingSample.count(_ < check)
    }).sum
  }

  @tailrec
  def calcInversionTailRec(sample: List[Int], count: Int = 0): Int = {
    sample match {
      case Nil => count
      case h :: tail => calcInversionTailRec(tail, count + tail.count(_ < h))
    }
  }


  println(calcInversion(inversion1))
  println(calcInversion(inversion2))
  println(calcInversion(inversion3))
  println(calcInversion(inversion4))

  println(calcInversionTailRec(inversion1))
  println(calcInversionTailRec(inversion2))
  println(calcInversionTailRec(inversion3))
  println(calcInversionTailRec(inversion4))

}
