// Vector has an evenly balanced access patterns, and of course It's non-linear data structure
// Bulk operations are much better
// Just like List, the Vector is immutable
// The fundamental operation is indexing

// Vector a List are implementations of Sequences (Subclass of Iterable)

// x +: xs similar to :: on List x :: xs
// x :+ xs

val numbers: Array[Int] = Array(8, 7, 6, 7, 2, 3)

numbers map (_ * -1)

val aString: String = "Hello Pandemic World 2020!"

aString filter (_.isUpper)
aString exists (_.isSpaceChar)
aString forall (_.isDigit)

val aRange: Range = 1 until 5 //1,2,3,4
val otherRange: Range = 1 to 5 //1,2,3,4,5

val seq: Seq[Int] = Seq(1, 2, 3)
val zipped: Seq[(Int, Char)] = seq zip aString
val unzipped: (Seq[Int], Seq[Char]) = zipped.unzip


aString.flatMap(List(".", _))
numbers.sum
numbers.product
zipped.max
aString.min


val M: Int = 4
val N: Int = 3

(1 to M).flatMap { x: Int => (1 to N).map((x, _)) }


def scalarProduct1(xs: Vector[Double], ys: Vector[Double]): Double = {
  (xs zip ys).map(xy => xy._1 * xy._2).sum
  //(xs zip ys).map { case (x, y) => x * y }.sum
}

def scalarProduct2(xs: Vector[Double], ys: Vector[Double]): Double = {
  (xs zip ys).foldLeft(0.0d) { (seed: Double, pair: (Double, Double)) =>
    seed + pair._1 * pair._2
  }
}

scalarProduct1(Vector(1.0, 3.0, 6.5), Vector(3.3, 5.0, -5.5))
scalarProduct2(Vector(1.0, 3.0, 6.5), Vector(3.3, 5.0, -5.5))


def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)


isPrime(17)
isPrime(13)
isPrime(12)
