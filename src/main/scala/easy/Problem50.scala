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
  case class Node(value: String, left: Tree, right: Tree) extends Tree
  case class Con(value: Int) extends Tree

  def evaluate(root: Tree): Int = {
    root match {
      case Node(v, l, r) if v == "*" => evaluate(l) * evaluate(r)
      case Node(v, l, r) if v == "/" => evaluate(l) / evaluate(r)
      case Node(v, l, r) if v == "+" => evaluate(l) + evaluate(r)
      case Node(v, l, r) if v == "-" => evaluate(l) - evaluate(r)
      case Con(i) => i
    }
  }

  val tree: Tree = Node("*", Node("+", Con(3), Con(2)), Node("+", Con(4), Con(5)))

  println(evaluate(tree))

}
