package easy

import scala.annotation.tailrec

object Problem33 extends App {

  // 2020-02-23

  // EASY
  // This problem was asked by Microsoft.
  //
  // Compute the running median of a sequence of numbers. That is, given a stream of numbers, print out the
  // median of the list so far on each new element.
  //
  // Recall that the median of an even-numbered list is the average of the two middle numbers.
  //
  // For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:
  //
  // 2
  // 1.5
  // 2
  // 3.5
  // 2
  // 2
  // 2

  val seq = List(2, 1, 5, 7, 2, 0, 5)

  def printRunningMedian(sequence: List[Int]): Unit = {
    @tailrec
    def printMedian(runSeq: List[Int], remSeq: List[Int]): Unit = {
      remSeq match {
        case Nil => println(calcMedian(runSeq))
        case h :: Nil =>
          println(calcMedian(runSeq))
          printMedian(h :: runSeq, Nil)
        case h :: tail =>
          println(calcMedian(runSeq))
          printMedian(h :: runSeq, tail)
      }
    }

    printMedian(sequence.head :: Nil, sequence.tail)
  }

  def calcMedian(seq: List[Int]): Double = {
    val sorted = seq.sorted

    if (sorted.size % 2 == 0) {
      val (pre: List[Int], post: List[Int]) = sorted.splitAt(sorted.size/2)
      (pre.last + post.head) / 2.0
    } else sorted(sorted.size/2)
  }

  printRunningMedian(seq)
}
