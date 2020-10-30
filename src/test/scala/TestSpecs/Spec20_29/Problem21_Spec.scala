package TestSpecs.Spec20_29

import TestSpecs.BaseSpec
import easy.Problem21._

class Problem21_Spec extends BaseSpec {

  val timeIntervals: List[(Int, Int)] = List(30 -> 75, 0 -> 50, 60 -> 150, 0 -> 60)

  "getIntervalOverlap" should "return number of overlaps" in {
    getIntervalOverlap(3, List(1 -> 3, 3 -> 4, 0 -> 2, 2 -> 4)) should be (2)
  }

  it should "return 0 for no overlaps" in {
    getIntervalOverlap(10, List(1 -> 3, 3 -> 4, 0 -> 2, 2 -> 4)) should be (0)
    getIntervalOverlap(0, List(1 -> 3, 3 -> 4, 0 -> 2, 2 -> 4)) should be (0)
    getIntervalOverlap(-1, List(1 -> 3, 3 -> 4, 0 -> 2, 2 -> 4)) should be (0)
  }

  it should "return 0 for empty list" in {
    getIntervalOverlap(10, List()) should be (0)
  }

  "countNumOfClassroomsNeeded" should "return maximum number of classrooms based on overlapping time ranges" in {
    countNumOfClassroomsNeeded(timeIntervals) should be (3)
  }

  it should "return 0 for empty list" in {
    countNumOfClassroomsNeeded(Nil) should be (0)
  }
}
