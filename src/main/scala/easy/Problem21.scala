package easy

import scala.annotation.tailrec

object Problem21 extends App {

  // 2019-11-18

  // EASY
  // This problem was asked by Snapchat.
  //
  // Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.
  //
  // For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.

  // Sort list by start times
  // Count overlap of end time of first one with time range of others
  // Repeat with next time interval, and remember the max value of overlaps (num of rooms)

  val timeIntervals: List[(Int, Int)] = List(30 -> 75, 0 -> 50, 60 -> 150, 0 -> 60)

  def getIntervalOverlap(end: Int, range: List[(Int, Int)]): Int = {
    range.foldLeft(0) { (r, t) => if (end > t._1 && end <= t._2) r + 1 else r}
  }

  def countNumOfClassroomsNeeded(intervals: List[(Int, Int)]): Int = {
    val sorted = intervals.sorted
    println(sorted)

    @tailrec
    def checkOverlap(checked: List[(Int, Int)], remain: List[(Int, Int)], result: Int): Int = {
      remain match {
        case Nil => result
        case r :: Nil =>
          val maxRooms: Int = Math.max(result, getIntervalOverlap(r._2, checked))
          checkOverlap(r :: checked, Nil, maxRooms)
        case r :: tail =>
          val maxRooms: Int = Math.max(result, getIntervalOverlap(r._2, checked ::: remain))
          checkOverlap(r :: checked, tail, maxRooms)
      }
    }

    checkOverlap(Nil, sorted, 0)
  }

  println(countNumOfClassroomsNeeded(timeIntervals))
}
