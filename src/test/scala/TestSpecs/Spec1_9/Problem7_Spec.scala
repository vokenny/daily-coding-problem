package TestSpecs.Spec1_9

import Problems1_9.Problem7
import TestSpecs.BaseSpec

class Problem7_Spec extends BaseSpec {

  "countDecodings" should "return positive count of decodings" in {
    Problem7.countDecodings("111") should be (3)
    Problem7.countDecodings("1815") should be (4)
    Problem7.countDecodings("207693") should be (5)
  }
}
