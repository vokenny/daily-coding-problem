package hard

object Problem18 extends App {

  // 2019-11-16

  // HARD
  // This problem was asked by Google.
  //
  // Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.
  //
  // For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
  //
  // 10 = max(10, 5, 2)
  // 7 = max(5, 2, 7)
  // 8 = max(2, 7, 8)
  // 8 = max(7, 8, 7)
  // Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.

  // .max for taking largest Ints
  // .sliding(k) for inspecting Ints of window size k
  // .map results of .sliding(k)

  val example: List[Int] = List(10, 5, 2, 7, 8, 7)

  def maxOfSubArraySize(k: Int, list: List[Int]): List[Int] = {
    if (k > 0 && k <= list.size) list.sliding(k).map(e => e.max).toList
    else throw new IllegalArgumentException
  }

  println(maxOfSubArraySize(3, example))
}
