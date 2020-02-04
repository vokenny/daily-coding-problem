package TestSpecs.Spec30_39

import Problems30_39.Problem31
import TestSpecs.BaseSpec

class Problem31_Spec extends BaseSpec {

  "editDistance" should "return integer counting how many changes are to be made" in {
    Problem31.editDistance("kitten", "sitting") should be (3)
    Problem31.editDistance("", "Hello") should be (5)
    Problem31.editDistance("Hello", "") should be (5)
    Problem31.editDistance("", "") should be (0)
  }
}
