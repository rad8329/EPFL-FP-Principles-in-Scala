def abs(x: Double): Double = if (x < 0) -x else x

def sqrt(x: Double): Double = {
  def isGoodEnough(guess: Double): Boolean = if (abs(guess * guess - x) / x < 1e-9) true else false

  def improve(guess: Double): Double = (guess + x / guess) / 2

  @scala.annotation.tailrec
  def sqrtIter(guess: Double): Double = if (isGoodEnough(guess)) guess else sqrtIter(improve(guess))

  sqrtIter(1.0)
}

sqrt(4)

def factorial(n: Int): Int = {
  @scala.annotation.tailrec
  def loop(accumulator: Int, n: Int): Int = if (n == 0) accumulator else loop(accumulator * n, n - 1)
  
  loop(1, n)
}

factorial(5)