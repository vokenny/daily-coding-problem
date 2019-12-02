import Problems20_29.Problem26
import org.scalatest.{FlatSpec, Matchers}

class Problem26_Spec extends FlatSpec with Matchers {

  val list: List[Int] = (0 to 10).toList

  "removeKthLast" should "return the list of remaining elements" in {
    Problem26.removeKthLast(3, list) should be (List(0, 1, 2, 3, 4, 5, 6, 7, 9, 10))
    Problem26.removeKthLast(11, list) should be (List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    Problem26.removeKthLast(1, list) should be (List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))
  }

  it should "return an empty list for list size of 1" in {
    Problem26.removeKthLast(1, List(1)) should be (List())
  }

  it should "throw IllegalArgumentException when k is less than 1" in {
    an [IllegalArgumentException] should be thrownBy Problem26.removeKthLast(0, list)
  }

  it should "throw IllegalArgumentException when given an empty list" in {
    an [IllegalArgumentException] should be thrownBy Problem26.removeKthLast(1, Nil)
    an [IllegalArgumentException] should be thrownBy Problem26.removeKthLast(1, List())
  }
}
