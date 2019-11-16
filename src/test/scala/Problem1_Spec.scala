import Problems1_9.Problem1
import org.scalatest.FlatSpec

class Problem1_Spec extends FlatSpec {

  "checkSum" should "return true for a sum found in the list" in {
    assert(Problem1.checkSum(5, List(1, 2, 3, 4, 5)))
  }

  it should "return false for a sum not found in the list" in {
    assert(!Problem1.checkSum(5, List(2, 4, 6, 8)))
  }

  it should "return true for a sum found in a list of 1" in {
    assert(Problem1.checkSum(1, List(1)))
  }

  it should "return false for a sum not found in a list of 1" in {
    assert(!Problem1.checkSum(2, List(1)))
  }

  it should "return false for an empty list" in {
    assert(!Problem1.checkSum(1, List()))
  }

  it should "return false for a Nil list" in {
    assert(!Problem1.checkSum(1, Nil))
  }
}