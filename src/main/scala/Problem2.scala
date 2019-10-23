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

  //  Create new list excluding the index
  //  Multiply all in new list
  //  Concatenate product as head of result
  //  Recursion with next index

  // Other approach could be to use the original list. but specifically ignore the given index
  // or to use filter to avoid the need for removeAt method

  def getProductsOfOtherElems(numList: List[Int]): List[Int] = {
    @tailrec
    def getProductsOfOtherElemsTailRec(index: Int, result: List[Int]): List[Int] = {
      index match {
        case -1 => result
        case i if i >= 0 && i < numList.size =>
          val otherElems: List[Int] = if (numList.size == 1) numList else removeAt(index, numList)
          getProductsOfOtherElemsTailRec(index - 1, otherElems.foldLeft(1) { (r, e) => r * e } :: result)
          // getProductsOfOtherElemsTailRec(index - 1, otherElems.product :: result)
      }
    }

    getProductsOfOtherElemsTailRec(numList.size - 1, Nil)
  }

  def removeAt[A](index: Int, list: List[A]): List[A] = {
    if (index >= 0 && index < list.size) {
      list.splitAt(index) match {
        case (Nil, Nil) => List()
        case (Nil, _ :: post) => post
        case (pre, _ :: post) => pre ::: post
      }
    } else throw new NoSuchElementException
  }

  // Functional approach is to not use indexes, and track lists as below

  def getProductsOfOtherElemsFunc(numList: List[Int]): List[Int] = {
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

  println(getProductsOfOtherElems(numbers))
  println(getProductsOfOtherElemsFunc(numbers))
}
