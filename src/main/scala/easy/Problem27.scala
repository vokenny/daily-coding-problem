package easy

import scala.annotation.tailrec

object Problem27 extends App {

  // 2020-11-01

  // EASY
  // This problem was asked by Facebook.
  //
  // Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).
  //
  // For example, given the string "([])[]({})", you should return true.
  //
  // Given the string "([)]" or "((()", you should return false.

  def isBalanced(sample: String): Boolean = {
    val openBrackets: List[Char] = List('(', '[', '{')
    val closeBrackets: List[Char] = List(')', ']', '}')
    val allBrackets: List[Char] = openBrackets ::: closeBrackets
    val bracketsMap: Map[Char, Char] = (closeBrackets zip openBrackets).toMap

    @tailrec
    def checkBalance(runningSample: List[Char], open: List[Char]): Boolean = {
      runningSample match {
        case Nil => if (open.nonEmpty) false else true
        case h :: tail if openBrackets.contains(h) => checkBalance(tail, open :+ h)
        case h :: tail if closeBrackets.contains(h) =>
          val balance: Boolean = bracketsMap.get(h).fold(false)(_ == open.last)
          if (balance) checkBalance(tail, open.init) else balance
      }
    }

    if (sample.forall(allBrackets.contains(_))) {
      if (sample.length % 2 != 0) false
      else checkBalance(sample.toList, Nil)
    } else throw new Exception(s"Accepted values in sample: [$allBrackets]. Found: [$sample]")

  }

//  println(isBalanced("([])[A]({})")) // Exception
  println(isBalanced("([])[]({})"))
  println(isBalanced("([)]"))
  println(isBalanced("((()"))
  println(isBalanced("(()"))

}
