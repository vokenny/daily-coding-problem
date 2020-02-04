package TestSpecs.Spec10_19

import Problems10_19.Problem13
import TestSpecs.BaseSpec

class Problem13_Spec extends BaseSpec {

  "lessOrEqualToUniqueChars" should "return true for empty an list" in {
    Problem13.lessOrEqualToUniqueChars(Nil, 2) should be (true)
  }

  it should "return true for a list of chars with fewer unique characters than n" in {
    Problem13.lessOrEqualToUniqueChars(List('x', 'y', 'x', 'x', 'y'), 3) should be (true)
    Problem13.lessOrEqualToUniqueChars(List('x', 'y', 'x', 'x', 'y'), 10) should be (true)
  }

  it should "return true for a list of chars with equal number of unique characters to n" in {
    Problem13.lessOrEqualToUniqueChars(List('x', 'y', 'x', 'x', 'y'), 2) should be (true)
  }

  it should "return false for a list of chars with more unique characters than n" in {
    Problem13.lessOrEqualToUniqueChars(List('x', 'y', 'z'), 2) should be (false)
  }

  it should "throw IllegalArgumentException for n < 1" in {
    an [IllegalArgumentException] should be thrownBy Problem13.lessOrEqualToUniqueChars(List('x', 'y', 'z'), 0)
  }

  "takeLarger" should "return larger list" in {
    Problem13.takeLarger(List('a', 'b', 'c'), List('a', 'b')) should be (List('a', 'b', 'c'))
    Problem13.takeLarger(List('a', 'b'), List('a', 'b', 'c')) should be (List('a', 'b', 'c'))
  }

  it should "return the latter option if they are equal in size" in {
    Problem13.takeLarger(List('a', 'b', 'c'), List('x', 'y', 'z')) should be (List('x', 'y', 'z'))
  }

  it should "return Nil for comparing empty lists" in {
    Problem13.takeLarger(List(), Nil) should be (Nil)
    Problem13.takeLarger(Nil, List()) should be (Nil)
  }

  "longestSubStrUniqueChars" should "return the longest substring with the specific unique number of characters" in {
    Problem13.longestSubStrUniqueChars("", 2) should be ("")
    Problem13.longestSubStrUniqueChars("aaaxyyz", 2) should be ("aaax")
    Problem13.longestSubStrUniqueChars("aaaxyxyyz", 2) should be ("xyxyy")
    Problem13.longestSubStrUniqueChars("aaaxyxyyzzyz", 2) should be ("yyzzyz")
    Problem13.longestSubStrUniqueChars("aaaxyxyyzzyz", 4) should be ("aaaxyxyyzzyz")
    Problem13.longestSubStrUniqueChars("aaaxyxyyzzyz", 5) should be ("aaaxyxyyzzyz")
  }

  it should "throw IllegalArgumentException for zero unique num of characters" in {
    an [IllegalArgumentException] should be thrownBy Problem13.longestSubStrUniqueChars("aaaxyyz", 0)
  }
}
