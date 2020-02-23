package TestSpecs.Spec30_39

import Problems30_39.Problem33
import TestSpecs.BaseSpec

class Problem33_Spec extends BaseSpec {

  "calcMedian" should "return the median in a list with odd number of elements" in {
      Problem33.calcMedian(List(1,2,3)) should be (2.0)
  }

  it should "return the median in a list with even number of elements" in {
      Problem33.calcMedian(List(1,2,3,4)) should be (2.5)
  }
}
