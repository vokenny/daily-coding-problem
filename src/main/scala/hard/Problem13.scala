package hard

import scala.annotation.tailrec

object Problem13 extends App {

  // 2019-10-18

  // HARD
  // This problem was asked by Amazon.
  //
  // Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
  //
  // For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".

  // counter following original query
  // param for current chars
  // param for remaining chars
  // param for tracking longest substring overall

  val example = "abcba"

  def lessOrEqualToUniqueChars(query: List[Char], n: Int): Boolean = {
    @tailrec
    def checkUniqueChars(count: Int, remain: List[Char]): Boolean = {
      (count, remain) match {
        case (_, Nil) => true
        case (0, r) => r.isEmpty
        case (c, r) => checkUniqueChars(c - 1, r.filter(c => c != r.head))
      }
    }

    if (n > 0) checkUniqueChars(n, query) else throw new IllegalArgumentException
  }

  def takeLarger(a: List[Char], b: List[Char]): List[Char] = if (a.size > b.size) a else b

  def longestSubStrUniqueChars(query: String, unique: Int): String = {
    @tailrec
    def longestSubStr(count: Int, current: List[Char], remain: List[Char], longest: List[Char]): String = {
      if (remain.isEmpty) longest.reverse.mkString
      else {
        if (lessOrEqualToUniqueChars(remain.head :: current, unique)) {
          longestSubStr(count, remain.head :: current, remain.tail, takeLarger(remain.head :: current, longest))
        } else longestSubStr(count + 1, Nil, query.drop(count + 1).toList, longest)
      }
    }

    longestSubStr(0, Nil, query.toList, Nil)
  }

  println(longestSubStrUniqueChars(example, 2))
}
