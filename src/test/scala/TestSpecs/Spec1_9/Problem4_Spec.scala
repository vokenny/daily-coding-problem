package TestSpecs.Spec1_9

import Problems1_9.Problem4
import TestSpecs.BaseSpec

class Problem4_Spec extends BaseSpec {

  "findFirstMissingPosInt" should "return the first positive missing integer for a given list of integers" in {
    assert(Problem4.findFirstMissingPosInt(List(3, 4, -1, 1)) == 2)
    assert(Problem4.findFirstMissingPosInt(List(1, 2, 0)) == 3)
    assert(Problem4.findFirstMissingPosInt(List(-5, -3, -1)) == 1)
  }

  it should "return IllegalArgumentException for an empty list" in {
    assertThrows[IllegalArgumentException] {
      Problem4.findFirstMissingPosInt(List())
    }
  }

  it should "return IllegalArgumentException for no list" in {
    assertThrows[IllegalArgumentException] {
      Problem4.findFirstMissingPosInt(Nil)
    }
  }
}
