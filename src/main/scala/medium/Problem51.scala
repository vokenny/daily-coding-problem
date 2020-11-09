package medium

import scala.util.Random

object Problem51 extends App {

  //  2020-11-

  //  MEDIUM
  //  This problem was asked by Facebook.
  //
  //  Given a function that generates perfectly random numbers between 1 and k (inclusive),
  //  where k is an input, write a function that shuffles a deck of cards represented as an array using only swaps.
  //
  //  It should run in O(N) time.
  //
  //  Hint: Make sure each one of the 52! permutations of the deck is equally likely.

  val deckOfCards: Array[String] = (for {
    value <- List("1", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K", "A")
    suit <- List("C", "D", "H", "S")
  } yield value + suit).toArray

  def rand(k: Int) = 1 + Random.nextInt(k)

  def shuffle(swaps: Int, deck: Array[String] = deckOfCards): Array[String] = {
    ???
    // Using rand, shuffle `swaps` amount of times using rand(swaps) to generate swapping of index positions?
    // Or have I misunderstood the question...?
  }

  println(shuffle(5))
}
