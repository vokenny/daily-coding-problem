package Problems10_19

import scala.annotation.tailrec
import scala.util.Random

object Problem15 extends App {

  // MEDIUM
  // This problem was asked by Facebook.
  //
  // Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.

  // Let the current element's index be i.
  //
  // Choose to 'remember' the current element at probability 1/i. When EOF is reached, produced the element you remember.
  //
  // This gives constant space because you only ever save one element to memory at any instance

  val streamStr: List[Int] = List.tabulate(20)(e => e + 1)

  def randomFromStream(stream: List[Int]): Int = {
    @tailrec
    def randomChar(count: Int, result: Int): Int = {
      count match {
        case 1 => randomChar(count + 1, stream.head)
        case c if c == stream.size => result
        case c if c > 1 =>
          if (Random.nextInt(count) == count - 1) randomChar(count + 1, stream.drop(count - 1).head)
          else randomChar(count + 1, result)
      }
    }

    if (stream.nonEmpty) randomChar(1, 0.toChar) else throw new IllegalArgumentException
  }

  println(randomFromStream(streamStr))
}
