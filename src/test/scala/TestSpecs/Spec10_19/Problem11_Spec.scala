package TestSpecs.Spec10_19

import TestSpecs.BaseSpec
import medium.Problem11

class Problem11_Spec extends BaseSpec {

  val dictionary = List("deutsche", "drive", "dog", "deer", "develop","deal", "dapper", "duo", "drink", "depth", "doppler")

  "autocomplete" should "return sorted list of matching query strings" in {
    Problem11.autocomplete(dictionary, "de") should be (List("deal", "deer", "depth", "deutsche", "develop"))
    Problem11.autocomplete(dictionary, "do") should be (List("dog", "doppler"))

    Problem11.autocompleteAlt(dictionary, "de") should be (List("deal", "deer", "depth", "deutsche", "develop"))
    Problem11.autocompleteAlt(dictionary, "do") should be (List("dog", "doppler"))
  }

  it should "return empty list for no matches" in {
    Problem11.autocomplete(dictionary, "cat") should be (List())
    Problem11.autocompleteAlt(dictionary, "cat") should be (List())
  }

  it should "return empty list for an empty dictionary" in {
    Problem11.autocomplete(Nil, "cat") should be (List())
    Problem11.autocompleteAlt(Nil, "cat") should be (List())
  }

  it should "throw IllegalArgumentException for an empty query string" in {
    an [IllegalArgumentException] should be thrownBy Problem11.autocomplete(dictionary, "")
    an [IllegalArgumentException] should be thrownBy Problem11.autocompleteAlt(dictionary, "")
  }
}
