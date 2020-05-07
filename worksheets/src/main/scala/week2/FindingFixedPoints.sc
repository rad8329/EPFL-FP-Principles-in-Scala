
val tolerance = 1e-4

def isCloseEnough(x: Double, y: Double): Boolean = math.abs((x - y) / x) / x < tolerance

def fixedPoint(f: Double => Double)(firstGuess: Double): Double = {
  @scala.annotation.tailrec
  def iteration(guess: Double): Double = {
    val next = f(guess)
    if (isCloseEnough(guess, next)) next
    else iteration(next)
  }

  iteration(firstGuess)
}

fixedPoint(x => 1 + x + 2)(1)

def averageDamp(f: Double => Double)(x: Double): Double = (x + f(x)) / 2

def sqrt(x: Double): Double = fixedPoint(averageDamp(y => x / y))(1)

sqrt(4)