import org.scalatest.{FlatSpec, Matchers}

class Problem9__Spec extends FlatSpec with Matchers {

  "countDecodings" should "return positive count of decodings" in {
    Problem9.largestSumNonAdj(List(2, 4, 6, 2, 5)) should be (13)
    Problem9.largestSumNonAdj(List(5, 1, 1, 5)) should be (10)
    Problem9.largestSumNonAdj(List(24, 78, 100, 1, 4, 51)) should be (175)
  }
}
