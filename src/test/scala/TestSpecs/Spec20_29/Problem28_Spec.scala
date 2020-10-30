package TestSpecs.Spec20_29

import TestSpecs.BaseSpec
import medium.Problem28


class Problem28_Spec extends BaseSpec {

  val wordsList: List[String] = List("the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog")

  "equalSpacing" should "apply equal spacing to the list of words based on max length of sentence" in {
    Problem28.equalSpacing(List("Hello", "World"), 16) should be ("Hello      World")
    Problem28.equalSpacing(List("Lyrical", "Word", "Smith"), 20) should be ("Lyrical  Word  Smith")
  }

  it should "return words put together if less than or equal to maximum length" in {
    Problem28.equalSpacing(List("Hello", "World"), 9) should be ("HelloWorld")
    Problem28.equalSpacing(List("Hello", "World"), 10) should be ("HelloWorld")
  }

  "justifyWithLength" should "apply equal spacing to the list of words based on max length of sentence" in {
    Problem28.justifyWithLength(wordsList, 16) should be (List("the  quick brown", "fox  jumps  over", "the   lazy   dog"))
  }
}
