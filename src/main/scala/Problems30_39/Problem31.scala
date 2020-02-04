package Problems30_39

import scala.annotation.tailrec

object Problem31 extends App {

  // EASY
  // This problem was asked by Google.
  //
  // The edit distance between two strings refers to the minimum number of character insertions, deletions,
  // and substitutions required to change one string to the other. For example, the edit distance between
  // “kitten” and “sitting” is three: substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.
  //
  // Given two strings, compute the edit distance between them.

  def editDistance(string1: String, string2: String): Int = {
    @tailrec
    def countEditDistance(str1: List[Char], str2: List[Char], count: Int): Int = {
      (str1.isEmpty, str2.isEmpty) match {
        case (false, false) => countEditDistance(str1.tail, str2.tail, if (str1.head == str2.head) count else count + 1)
        case (true, false) => countEditDistance(Nil, str2.tail, count + 1)
        case (false, true) => countEditDistance(str1.tail, Nil, count + 1)
        case (true, true) => count
      }
    }

    countEditDistance(string1.toList, string2.toList, 0)
  }

  println(editDistance("kitten", "sitting"))
}
