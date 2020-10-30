package medium

import scala.annotation.tailrec

object Problem11 extends App {

  // 2019-10-31

  // MEDIUM
  // This problem was asked by Twitter.
  //
  // Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.
  //
  // For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].
  //
  // Hint: Try pre-processing the dictionary into a more efficient data structure to speed up queries.

  val dictionary: List[String] = List("deutsche", "drive", "dog", "deer", "develop", "deal", "dapper", "duo", "drink", "depth", "doppler")

  // Sort alphabetically
  // Filter by substring
  // Return all that match filter

  def autocomplete(dictionary: List[String], queryStr: String): List[String] = {
    if (queryStr.nonEmpty) dictionary.filter(e => e.contains(queryStr)).sorted else throw new IllegalArgumentException
  }

  def autocompleteAlt(dictionary: List[String], queryStr: String): List[String] = {
    @tailrec
    def autocompleteTailRec(remList: List[String], result: List[String]): List[String] = {
      if (queryStr.nonEmpty)
        remList match {
          case h :: tail => if (h.contains(queryStr)) autocompleteTailRec(tail, h :: result) else autocompleteTailRec(tail, result)
          case _ => result.reverse
        }
      else throw new IllegalArgumentException
    }

    autocompleteTailRec(dictionary.sorted, Nil)
  }

  println(autocomplete(dictionary, "de"))
  println(autocompleteAlt(dictionary, "de"))
}
