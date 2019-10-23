object Problem3 extends App {

  // MEDIUM
  // This problem was asked by Google.
  //
  // Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s),
  // which deserializes the string back into the tree.
  //
  // For example, given the following Node class
  //
  // class Node:
  // def __init__(self, val, left=None, right=None):
  // self.val = val
  // self.left = left
  // self.right = right
  // The following test should pass:
  //
  //   node = Node('root', Node('left', Node('left.left')), Node('right'))
  // assert deserialize(serialize(node)).left.left.val == 'left.left'

  sealed trait Tree[A]

  final case class Node[A](leftChild: Tree[A], rightChild: Tree[A])
  final case class Leaf[A](value: A)

  def serialize[A](tree: Tree[A]): String = ???
  def deserialize[A](treeStr: String): Tree[A] = ???
}
