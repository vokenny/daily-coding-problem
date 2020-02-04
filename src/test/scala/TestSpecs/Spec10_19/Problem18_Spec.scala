package TestSpecs.Spec10_19

import Problems10_19.Problem18
import TestSpecs.BaseSpec

class Problem18_Spec extends BaseSpec {

  val example: List[Int] = List(10, 5, 2, 7, 8, 7)

  "maxOfSubArraySize" should "return list of max values of each subarray of length k" in {
    Problem18.maxOfSubArraySize(4, example) should be (List(10, 8, 8))
    Problem18.maxOfSubArraySize(3, example) should be (List(10, 7, 8, 8))
    Problem18.maxOfSubArraySize(2, example) should be (List(10, 5, 7, 8, 8))
  }

  it should "throw IllegalArgumenException for a length k of 0" in {
    an [IllegalArgumentException] should be thrownBy Problem18.maxOfSubArraySize(0, example)
  }

  it should "throw IllegalArgumenException for a negative length k" in {
    an [IllegalArgumentException] should be thrownBy Problem18.maxOfSubArraySize(-1, example)
  }

  it should "throw IllegalArgumenException for an empty list" in {
    an [IllegalArgumentException] should be thrownBy Problem18.maxOfSubArraySize(2, Nil)
    an [IllegalArgumentException] should be thrownBy Problem18.maxOfSubArraySize(2, List())
  }
}
