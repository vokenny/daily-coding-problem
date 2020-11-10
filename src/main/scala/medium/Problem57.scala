package medium

import scala.annotation.tailrec

object Problem57 extends App {

  //  2020-11-10

  //  MEDIUM
  //  This problem was asked by Amazon.
  //
  //  Given a string s and an integer k, break up the string into multiple lines such that
  //  each line has a length of k or less. You must break it up so that words don't break across lines.
  //  Each line has to have the maximum possible amount of words.
  //  If there's no way to break the text up, then return null.
  //
  //  You can assume that there are no spaces at the ends of the string and that there is exactly
  //  one space between each word.
  //
  //  For example, given the string "the quick brown fox jumps over the lazy dog" and k = 10, you should return:
  //  ["the quick", "brown fox", "jumps over", "the lazy", "dog"]. No string in the list has a length of more than 10.

  def splitByLen(sample: String, k: Int): List[String] = {
    val words: Array[String] = sample.split("\\s")

    @tailrec
    def collect(prev: String, remain: Array[String], res: Array[String]): Array[String] = {
      remain match {
        case Array() => if (prev.nonEmpty) res :+ prev else res
        case Array(h, tail @ _*) =>
          if (prev.isEmpty) collect(h, tail.toArray, res)
          else {
            val newStr: String = prev + " " + h
            if (newStr.length <= 10) collect(tail.head, tail.tail.toArray, res :+ newStr)
            else collect(h, tail.toArray, res :+ prev)
          }
      }
    }

    collect("", words, Array()).toList
  }

  println(splitByLen("the quick brown fox jumps over the lazy dog", 10))
}
