package medium

import scala.annotation.tailrec

object Problem22 extends App {

  // 2020-11-01

  // MEDIUM
  // This problem was asked by Microsoft.
  //
  // Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.
  //
  // For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].
  //
  // Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].

  val dictionary: List[String] = List("quick", "brown", "the", "fox", "bed", "bath", "bedbath", "and", "beyond")

  def reconstructSentence1(sentence: String): List[String] = {
    var result: List[String] = List()
    val sanitisedSentence: String = sentence.filter(_.isLetter).toLowerCase

    sanitisedSentence.foldLeft("") { (acc, char) =>
      dictionary.find(_ == acc + char).fold(acc + char)(word => {
        result = result :+ word
        ""
      })
    }

    if (result.mkString == sanitisedSentence) result else Nil
  }

  def reconstructSentence2(sentence: String): List[String] = {
    @tailrec
    def reconstructFromDictionary(sentence: List[Char], acc: String, results: List[String]): List[String] = {
      sentence match {
        case Nil =>
          if (acc.isEmpty) results
          else {
            dictionary.find(_ == acc) match {
              case Some(word) => results :+ word
              case None => Nil
            }
          }
        case h :: tail =>
          val searchTerm: String = acc + h
          dictionary.find(_ == searchTerm) match {
            case Some(word) => reconstructFromDictionary(tail, "", results :+ word)
            case None => reconstructFromDictionary(tail, searchTerm, results)
          }
      }
    }

    val sanitisedSentenceChars: List[Char] = sentence.filter(_.isLetter).toLowerCase.toList
    reconstructFromDictionary(sanitisedSentenceChars, "", Nil)
  }

  println(reconstructSentence1("the Quick 1! brown fox bedbathandbeyond"))
  println(reconstructSentence1("the Quick 1! brown fox bedbathandbeyond extra"))

  println(reconstructSentence2("the Quick 1! brown fox bedbathandbeyond"))
  println(reconstructSentence2("the Quick 1! brown fox bedbathandbeyond extra"))

}
