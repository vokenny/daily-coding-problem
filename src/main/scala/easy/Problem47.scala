package easy

import scala.annotation.tailrec

object Problem47 extends App {

  // 2020-11-09

  //  EASY
  //  This problem was asked by Facebook.
  //
  //  Given a array of numbers representing the stock prices of a company in chronological order,
  //  write a function that calculates the maximum profit you could have made from buying and
  //  selling that stock once. You must buy before you can sell it.
  //
  //  For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could
  //  buy the stock at 5 dollars and sell it at 10 dollars.

  def stonksUpProfit(stockPrices: Array[Int]): Int = {
    @tailrec
    def findMaxProfit(remain: Array[Int], res: Int): Int = {
      remain match {
        case Array(_) => res
        case Array(h1, tail @ _*) =>
          val maybeNewMax: Int = tail.foldLeft(0) { (max, stk) => max.max(stk - h1) }
          findMaxProfit(tail.toArray, res.max(maybeNewMax))
      }
    }

    findMaxProfit(stockPrices, 0)
  }

  println(stonksUpProfit(Array(9, 11, 8, 5, 7, 10)))

}
