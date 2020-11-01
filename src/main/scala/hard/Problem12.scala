package hard

object Problem12 extends App {

  // 2020-11-01
  // N.B. Watched Dynamic programming solution to understand the problem & solution
  // https://www.youtube.com/watch?v=5o-kdjv7FD0

  // HARD
  // This problem was asked by Amazon.
  //
  // There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time.
  // Given N, write a function that returns the number of unique ways you can climb the staircase.
  // The order of the steps matters.
  //
  // For example, if N is 4, then there are 5 unique ways:
  //
  // 1, 1, 1, 1
  // 2, 1, 1
  // 1, 2, 1
  // 1, 1, 2
  // 2, 2
  //
  // What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number
  // from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.

  def stepCountVariations(steps: Int, stepSizes: List[Int]): Int = {
    if (steps == 0) 1
    else {
      for (step <- stepSizes) yield {
        val remainingSteps = steps - step
        if (remainingSteps >= 0) stepCountVariations(remainingSteps, stepSizes) else 0
      }
    }.sum
  }

  println(stepCountVariations(4, List(1, 2)))
  println(stepCountVariations(4, List(1, 2, 3)))
  println(stepCountVariations(5, List(1, 3, 5)))

}
