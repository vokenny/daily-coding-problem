package easy

import scala.annotation.tailrec
import scala.util.Random

object Problem45 extends App {

  // 2020-11-03

  //  EASY
  //  This problem was asked by Two Sigma.
  //
  //  Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability,
  //  implement a function rand7() that returns an integer from 1 to 7 (inclusive)

  def rand5(): Int = 1 + Random.nextInt(5)

  @tailrec
  def rand7(): Int = {
    val random: Int = 5 * (rand5() - 1) + rand5()
    if (random <= 21) random % 7 + 1 else rand7()
  }

  val results: Seq[(Int, Int)] =
    (1 to 10000 map (_ => rand7())
      groupBy (value => value)        // group all instances by the values: 1 -> (1, 1, ..., 1)
      mapValues(_.size))              // compress it all to it's instance count: 1 -> 1234
      .toSeq.sortBy(_._1)             // cast to Seq, sort by key: (1, 1234), (2, 1243), ...

  println(results)

}
