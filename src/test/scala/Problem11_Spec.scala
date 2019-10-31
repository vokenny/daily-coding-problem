import org.scalatest.{FlatSpec, Matchers}

class Problem11_Spec extends FlatSpec with Matchers {

  val dictionary = List("deutsche", "drive", "dog", "deer", "develop","deal", "dapper", "duo", "drink", "depth", "doppler")

  "autocomplete" should "return sorted list of matching query strings" in {
    Problem11.autocomplete(dictionary, "de") should be (List("deal", "deer", "depth", "deutsche", "develop"))
    Problem11.autocomplete(dictionary, "do") should be (List("dog", "doppler"))
  }

  it should "return empty list for no matches" in {
    Problem11.autocomplete(dictionary, "cat") should be (List())
  }
}
