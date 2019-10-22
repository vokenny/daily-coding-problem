import scala.annotation.tailrec

object Problem1 extends App {

  //  EASY
  //  This problem was recently asked by Google.
  //
  //    Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
  //
  //    For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
  //
  //  Bonus: Can you do this in one pass?

  val numbers: List[Int] = 10 :: 15 :: 3 :: 7 :: Nil

  //  Recursion:
  //    - Check if any work with index 0
  //    - if yes true
  //    - if no discard and repeat process with remaining list

  def checkSum(x: Int, list: List[Int]): Boolean = {
    @tailrec
    def checkSumTailRec(c: Int, l: List[Int]): Boolean = {
      l match {
        case Nil => false
        case h :: Nil => if (h == x) true else false
        case h :: tail =>
          if (h + tail(c) == x) true
          else if (c == tail.size - 1) checkSumTailRec(0, tail)
          else checkSumTailRec(c + 1, l)
      }
    }

    checkSumTailRec(0, list)
  }

  println(checkSum(18, numbers))
}
