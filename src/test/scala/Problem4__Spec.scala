import org.scalatest.FlatSpec

class Problem4__Spec extends FlatSpec {

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
