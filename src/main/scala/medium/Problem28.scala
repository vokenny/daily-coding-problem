package medium

import scala.annotation.tailrec

object Problem28 extends App {

  // 2019-12-02

  // MEDIUM
  // This problem was asked by Palantir.
  //
  // Write an algorithm to justify text. Given a sequence of words and an integer line length k, return a list of strings which represents each line, fully justified.
  //
  // More specifically, you should have as many words as possible in each line. There should be at least one space between each word.
  // Pad extra spaces when necessary so that each line has exactly length k. Spaces should be distributed as equally as possible,
  // with the extra spaces, if any, distributed starting from the left.
  //
  // If you can only fit one word on a line, then you should pad the right-hand side with spaces.
  //
  // Each word is guaranteed not to be longer than k.
  //
  // For example, given the list of words ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"] and k = 16, you should return the following:
  //
  // ["the  quick brown", # 1 extra space on the left
  // "fox  jumps  over", # 2 extra spaces distributed evenly
  // "the   lazy   dog"] # 4 extra spaces distributed evenly

  val wordsList: List[String] = List("the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog")

  // Build current line, and add words to it if it doesn't exceed k length
  // Once you hit k limit, justify it
  // Save it to result
  // Build a new current line

  def equalSpacing(content: List[String], maxLen: Int): String = {
    @tailrec
    def addSpaces(added: List[String], notAdded: List[String]): String = {
      val sentence: String = added.mkString + notAdded.mkString

      if (sentence.length < maxLen) {
        notAdded match {
          case Nil => addSpaces(Nil, added)
          case w :: Nil => addSpaces(Nil, added ::: w :: Nil)
          case w :: tail => addSpaces(added ::: w + " " :: Nil, tail)
        }
      } else sentence
    }

    addSpaces(Nil, content)
  }

  def justifyWithLength(content: List[String], maxLen: Int): List[String] = {
    @tailrec
    def justify(current: List[String], words: List[String], result: List[String]): List[String] = {
      words match {
        case Nil => result
        case w :: Nil => justify(Nil, Nil, result ::: equalSpacing(current ::: w :: Nil, maxLen) :: Nil)
        case w :: tail =>
          val newLine = (current ::: w :: Nil).mkString
          if (newLine.length > maxLen) justify(Nil, current.last :: words, result ::: equalSpacing(current.init, maxLen) :: Nil)
          else justify(current ::: w :: Nil, tail, result)
      }
    }

    justify(Nil, content, Nil)
  }

  println(justifyWithLength(wordsList, 16))
}
