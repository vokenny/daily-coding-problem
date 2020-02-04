package Problems30_39

import scala.annotation.tailrec

object Problem33 extends App {

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

  def printRunningMedian(sequence: List[Int]): Unit = {
    @tailrec
    def printMedian(runSeq: List[Int], remSeq: List[Int]): Unit = {
      remSeq match {
        case Nil => println(runSeq.sorted)
        case h :: Nil =>
          println(runSeq.sorted)
          printMedian(h :: runSeq, Nil)
        case h :: tail =>
          println(runSeq.sorted)
          printMedian(h :: runSeq, tail)
      }
    }

    printMedian(Nil, sequence)
  }

  def printRunningMean(sequence: List[Int]): Unit = {
    sequence.foldLeft((0.0, 0.0, 0.0)) { (r, s) => {
      val sum: Double = r._1 + s
      val count: Double = r._3 + 1
      val med: Double = sum/count
      println(med)
      (sum, med, count)
    }}
  }

  val seq = List(2, 1, 5, 7, 2, 0, 5)

  printRunningMedian(seq)
}
