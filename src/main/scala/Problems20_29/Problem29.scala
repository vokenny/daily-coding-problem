package Problems20_29

import scala.annotation.tailrec

object Problem29 extends App {

  // EASY
  // This problem was asked by Amazon.
  //
  // Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent
  // repeated successive characters as a single count and character.
  // For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".
  //
  // Implement run-length encoding and decoding. You can assume the string to be encoded have no digits
  // and consists solely of alphabetic characters. You can assume the string to be decoded is valid.

  def encode(input: String): String = {
    @tailrec
    def encode_(toEncode: String, result: String): String = {
      if (toEncode.nonEmpty) {
        val (group: String, remaining: String) = toEncode.span(c => c == toEncode.head)
        encode_(remaining, result + group.length + group.head)
      } else result
    }

    encode_(input, "")
  }

  def decode(input: String): String = {
    @tailrec
    def decode_(toDecode: List[Char], result: List[Char]): String = {
      toDecode match {
        case Nil => result.reverse.mkString
        case h :: m :: t => decode_(t, List.fill(h.toString.toInt)(m) ::: result)
        case _ => throw new IllegalArgumentException
      }
    }

    decode_(input.toList, Nil)
  }

  println(encode("AAAABBBCCDAA"))
  println(decode("4A3B2C1D2A"))
}
