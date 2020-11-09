package easy


object Problem50 extends App {

  // 2020-11-09

  //  EASY
  //  This problem was asked by Microsoft.
  //
  //  Suppose an arithmetic expression is given as a binary tree.
  //  Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.
  //  Given the root to such a tree, write a function to evaluate it.
  //  For example, given the following tree:
  //
  //      *
  //     / \
  //    +    +
  //   / \  / \
  //  3  2  4  5
  //
  //  You should return 45, as it is (3 + 2) * (4 + 5).

  sealed trait Tree
  case class Node(value: String, left: Tree = Empty, right: Tree = Empty) extends Tree
  case object Empty extends Tree

  def evaluate(root: Tree): Int = {
    root match {
      case Node(v, l, r) if v == "*" => evaluate(l) * evaluate(r)
      case Node(v, l, r) if v == "+" => evaluate(l) + evaluate(r)
      case Node(v, _, _) => v.toInt
    }
  }

  val tree: Tree = Node("*", Node("+", Node("3"), Node("2")), Node("+", Node("4"), Node("5")))

  println(evaluate(tree))

}
