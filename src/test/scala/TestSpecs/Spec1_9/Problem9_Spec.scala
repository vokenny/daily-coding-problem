package TestSpecs.Spec1_9

import Problems1_9.Problem9
import TestSpecs.BaseSpec

class Problem9_Spec extends BaseSpec {

  "countDecodings" should "return positive count of decodings" in {
    Problem9.largestSumNonAdj(List(2, 4, 6, 2, 5)) should be (13)
    Problem9.largestSumNonAdj(List(5, 1, 1, 5)) should be (10)
    Problem9.largestSumNonAdj(List(24, 78, 100, 1, 4, 51)) should be (175)
  }
}
