package TestSpecs.Spec20_29

import Problems20_29.Problem20
import TestSpecs.BaseSpec

class Problem20_Spec extends BaseSpec {

  "findIntersect" should "return first value found in both lists" in {
    Problem20.findIntersect(List(10, 5, 2, 7, 8, 7), List(10, 7)) should be (Some(10))
    Problem20.findIntersect(List(10, 5, 2, 7, 8, 7), List(9, 1000, 5)) should be (Some(5))
  }

  it should "return None if it finds no intersection" in {
    Problem20.findIntersect(List(10, 5, 2, 7, 8, 7), List(1, 3, 9)) should be (None)
  }

  it should "return None if either parameter is empty" in {
    Problem20.findIntersect(List(10, 5, 2, 7, 8, 7), Nil) should be (None)
    Problem20.findIntersect(List(), List(9, 1000, 5)) should be (None)
    Problem20.findIntersect(Nil, List()) should be (None)
  }
}
