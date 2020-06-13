package week5

object ImplicitParameters extends App {
  def mergeSortWithNoSL[T](xs: List[T])(lowerThan: (T, T) => Boolean): List[T] = {

    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (z :: zs, w :: ws) => if (lowerThan(z, w)) z :: merge(zs, ys) else w :: merge(xs, ws)
    }

    val n = xs.length / 2

    if (n == 0) xs
    else {

      val (left, right) = xs splitAt n

      merge(mergeSortWithNoSL(left)(lowerThan), mergeSortWithNoSL(right)(lowerThan))
    }
  }

  def mergeSort[T](xs: List[T])(implicit ordering: Ordering[T]): List[T] = {

    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (z :: zs, w :: ws) => if (ordering.lt(z, w)) z :: merge(zs, ys) else w :: merge(xs, ws)
    }

    val n = xs.length / 2

    if (n == 0) xs
    else {

      val (left, right) = xs splitAt n

      merge(mergeSort(left), mergeSort(right))
    }
  }

  val nums = List(2, 7, -2, 0, 1, 8)

  println(mergeSortWithNoSL(nums)((x: Int, y: Int) => x < y))

  val fruits = List("bananos", "peras", "aguacates", "manzanas", "mangos", "fresas", "naranjas")

  println(mergeSortWithNoSL(fruits)((x: String, y: String) => x < y))

  // instead, we could do the last using standard library

  //import math.Ordering
  //println(mergeSort(nums)(Ordering.Int))
  //println(mergeSort(fruits)(Ordering.String))

  println(mergeSort(nums)) // With implicit parameter
  println(mergeSort(fruits)) // With implicit parameter
}
