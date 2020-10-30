package TestSpecs.Spec20_29

import TestSpecs.BaseSpec
import easy.Problem29

class Problem29_Spec extends BaseSpec {

  "encode" should "return run-length encoding of the sequence" in {
    Problem29.encode("1111LLLOOOLLL") should be ("413L3O3L")
    Problem29.encode("APL??ROOWAFFLE") should be ("1A1P1L2?1R2O1W1A2F1L1E")
    Problem29.encode("AAAA BBBCCD") should be ("4A1 3B2C1D")
    Problem29.encode("") should be ("")
  }

  "decode" should "" in {
    Problem29.decode("4A3B2C1D2A") should be ("AAAABBBCCDAA")
    Problem29.decode("1?") should be ("?")
  }

  it should "throw IllegalArgumentException for odd number of characters" in {
    an [IllegalArgumentException] should be thrownBy Problem29.decode("1")
    an [IllegalArgumentException] should be thrownBy Problem29.decode("2A3")
  }

  it should "throw IllegalArgumentException if first pairs are not numbers" in {
    an [IllegalArgumentException] should be thrownBy Problem29.decode("A")
    an [IllegalArgumentException] should be thrownBy Problem29.decode("AAA")
    an [IllegalArgumentException] should be thrownBy Problem29.decode("A2B2")
  }
}
