package medium

import scala.annotation.tailrec

object Problem26 extends App {

  // 2019-12-02

  // MEDIUM
  // This problem was asked by Google.
  //
  // Given a singly linked list and an integer k, remove the kth last element from the list. k is guaranteed to be smaller than the length of the list.
  //
  // The list is very long, so making more than one pass is prohibitively expensive.
  //
  // Do this in constant space and in one pass.

  // Using two pointers
  // Move the first pointer until it equals k
  // Then keep moving both pointers until the first pointer reaches the end
  // Whatever the second pointer has landed on is the kth last element from the end

  val list: List[Int] = (0 to 100).toList

  def removeKthLast[A](k: Int, list: List[A]): List[A] = {
    @tailrec
    def traverse(beforeKth: List[A], others: List[A], notChecked: List[A]): List[A] = {
      notChecked match {
        case Nil => beforeKth.init ::: others.tail
        case h :: Nil => traverse(beforeKth ::: others.head :: Nil, others ::: h :: Nil, Nil)
        case h :: tail =>
          if (others.size != k - 1) traverse(beforeKth, others ::: h :: Nil, tail)
          else traverse(beforeKth ::: others.head :: Nil, others.tail ::: h :: Nil, tail)
      }
    }

    if (list.nonEmpty) {
      k match {
        case 1 => list.init
        case i if i > 1 => traverse(Nil, Nil, list)
        case _ => throw new IllegalArgumentException
      }
    } else throw new IllegalArgumentException
  }

  println(removeKthLast(3, list))
}
