package Problems40_49

import scala.annotation.tailrec

object Problem42 extends App {

//  HARD
//  This problem was asked by Google.
//
//  Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k.
//  If such a subset cannot be made, then return null.
//
//  Integers can appear more than once in the list. You may assume all numbers in the list are positive.
//
//  For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.

  val s: List[Int] = List(12, 1, 61, 5, 9, 2)

  def sumSubset(listOfInts: List[Int], target: Int): List[Int] = {
    @tailrec
    def subtractToZero(ints: List[Int], savedNums: List[Int], zeroTarg: Int): List[Int] = {
      zeroTarg.signum match {
        case -1 => subtractToZero(savedNums.init ::: ints, Nil, target)
        case 0 => savedNums
        case 1 => subtractToZero(ints.tail, savedNums ::: ints.head :: Nil, zeroTarg - ints.head)
      }
    }

    subtractToZero(listOfInts.filter(_ <= target).sorted.reverse, Nil, target)
  }

  println(sumSubset(s, 24))
}
