import scala.annotation.tailrec

object Problem2 extends App {

  // HARD
  // This problem was asked by Uber.
  //
  //  Given an array of integers, return a new array such that each element at index i of the new array is the product of
  //  all the numbers in the original array except the one at i.
  //
  //    For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
  //
  //    Follow-up: what if you can't use division?

  val numbers: List[Int] = 1 :: 2 :: 3 :: 4 :: 5 :: Nil

  // Functional approach is to not use indexes, and track lists

  def getProductsOfOtherElems(numList: List[Int]): List[Int] = {
    @tailrec
    def getProductsOfOtherElemsTailRec(seenSoFar: List[Int], yetToSee: List[Int], result: List[Int]): List[Int] = {
      yetToSee match {
        case Nil => result.reverse
        case h :: Nil => getProductsOfOtherElemsTailRec(h :: seenSoFar, Nil, seenSoFar.product :: result)
        case h :: tail => getProductsOfOtherElemsTailRec(h :: seenSoFar, tail, (seenSoFar.product * tail.product) :: result)
      }
    }

    getProductsOfOtherElemsTailRec(Nil, numList, Nil)
  }

  // Callum's approach

  def getProductsOfOtherElemsCallum(list: List[Int]): List[Int] = {
    list.map(x => list.foldLeft(1)((y, z) => if (z != x) y * z else y))
  }

  println(getProductsOfOtherElems(numbers))
}
