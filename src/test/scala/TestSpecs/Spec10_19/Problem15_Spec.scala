package TestSpecs.Spec10_19

import Problems10_19.Problem15
import TestSpecs.BaseSpec

class Problem15_Spec extends BaseSpec {

  val streamStr: List[Int] = List.tabulate(20)(e => e + 1)
  val streamStrEmpty: List[Int] = List.tabulate(0)(e => e + 1)

  "randomFromStream" should "return uniformly distributed random integer" in {
    Problem15.randomFromStream(streamStr).isInstanceOf[Int] should be (true)
  }

  it should "throw IllegalArgumentException for empty stream" in {
    an [IllegalArgumentException] should be thrownBy Problem15.randomFromStream(streamStrEmpty)
  }
}