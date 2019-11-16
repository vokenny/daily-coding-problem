import Problems10_19.Problem15
import org.scalatest.{FlatSpec, Matchers}

class Problem15_Spec extends FlatSpec with Matchers {

  val streamStr: LazyList[Int] = LazyList.tabulate(20)(e => e + 1)
  val streamStrEmpty: LazyList[Int] = LazyList.tabulate(0)(e => e + 1)

  "randomFromStream" should "return uniformly distributed random integer" in {
    Problem15.randomFromStream(streamStr).isInstanceOf[Int] should be (true)
  }

  it should "throw IllegalArgumentException for empty stream" in {
    an [IllegalArgumentException] should be thrownBy Problem15.randomFromStream(streamStrEmpty)
  }
}