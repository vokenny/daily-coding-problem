package medium

object Problem10 extends App {

  // 2020-10-30

  // MEDIUM
  // This problem was asked by Apple.
  //
  // Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.

  def jobScheduler: Long => (Int => Any) => Int => Any =
    (timeInMilliseconds: Long) => (f: Int => Any) => (n: Int) => {
      Thread.sleep(timeInMilliseconds)
      f(n)
    }

  val execIn1000ms: (Int => Any) => Int => Any = jobScheduler(1000)
  val addsFive: Int => Any = execIn1000ms(x => x + 5)

  println(addsFive(10))

}
