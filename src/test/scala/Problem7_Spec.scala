import org.scalatest.{FlatSpec, Matchers}

class Problem7_Spec extends FlatSpec with Matchers {

  "countDecodings" should "return positive count of decodings" in {
    Problem7.countDecodings("111") should be (3)
    Problem7.countDecodings("1815") should be (4)
    Problem7.countDecodings("207693") should be (5)
  }
}
