
def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)

val n = 7

// a range is an IndexedSeq

// absolutely no readable
(1 until n) map (i => (1 until i) map (j => (i, j)))
((1 until n) map (i => (1 until i) map (j => (i, j)))).flatten
// The same as above
(1 until n) flatMap (i => (1 until i) map (j => (i, j)))
// xs flatMap f = (xs map f).flatten


(1 until n) flatMap (i => (1 until i) map (j => (i, j))) filter (pair =>
  isPrime(pair._1 + pair._2)
  ) map (pair => pair._1 + pair._2)


// Let's do It so readable

//case class Person(name: String, age: Int)
//
//val persons = Vector(Person("Juan Topo", 115), Person("Nelson Ruffino", 15))
//
//for (p <- persons if p.age > 20) yield p.name
// The same as above
//persons filter (p => p.age > 20) map (_.name)

for {
  i <- 1 until n
  j <- 1 until i
  if isPrime(i + j)
} yield (i + j)


def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
  (for ((x, y) <- xs zip ys) yield x * y).sum


val A = Vector(1.0, 3.0, 6.5)
val B = Vector(3.5, 5.0, -5.5)

scalarProduct(A, B)
