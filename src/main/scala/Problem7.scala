import scala.annotation.tailrec

object Problem7 extends App {

  // MEDIUM
  // This problem was asked by Facebook.
  //
  // Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
  //
  // For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
  //
  // You can assume that the messages are decodable. For example, '001' is not allowed.

  val message: String = "111"

  // 3 - 9 => single digits only
  // 10 => pair only
  // 20 => pair only
  // 1 or 11 - 19
  // 2 or 21 - 26

  def countDecodings(encoded: String): Int = {
    @tailrec
    def countDecodingsTailRec(seenSoFar: List[Int], yetToSee: List[Int], result: Int): Int = {
      yetToSee match {
        case Nil => result
        case h :: Nil => countDecodingsTailRec(h :: seenSoFar, Nil, result + 1)
        case h :: tail if 3 <= h && h <= 9 => countDecodingsTailRec(h :: seenSoFar, tail, result + 1)
        case h :: m :: tail if m == 0 => countDecodingsTailRec(h :: m :: seenSoFar, tail, result + 1)
        case h :: m :: tail => countDecodingsTailRec(h :: m :: seenSoFar, tail, result + 2)
      }
    }

    countDecodingsTailRec(Nil, encoded.toList.map(e => e.toString.toInt), 0)
  }

  println(countDecodings(message))
}
