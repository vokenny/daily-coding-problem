package easy

import scala.collection.mutable.ListBuffer

object Problem43 extends App {

  // 2020-03-02

  //  EASY
  //  This problem was asked by Amazon.
  //
  //  Implement a stack that has the following methods:
  //
  //  push(val), which pushes an element onto the stack
  //  pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it should throw an error or return null.
  //  max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.
  //
  //  Each method should run in constant time.

  val stack: ListBuffer[Int] = new ListBuffer()

  def push(value: Int): Unit = stack.insert(0, value)

  def pop(): Int = stack.remove(0)

  def max(): Int = stack.max

  push(2)
  push(30)
  push(8)
  push(3)
  push(12)

  println(stack)
  println(stack.max)
  println(pop())
  println(stack)
}
