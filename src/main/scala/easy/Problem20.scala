package easy

object Problem20 extends App {

  // 2019-11-18

  // EASY
  // This problem was asked by Google.
  //
  // Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
  //
  // For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
  //
  // In this example, assume nodes with the same value are the exact same node objects.
  //
  // Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.

  val list1: List[Int] = List(3, 7, 8, 10)
  val list2: List[Int] = List(99, 1, 8, 10)

  def findIntersect(l1: List[Int], l2: List[Int]): Option[Int] = l1.find(e => l2.contains(e))

  println(findIntersect(list1, list2))
}
