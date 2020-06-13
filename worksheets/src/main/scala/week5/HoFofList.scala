package week5


object HoFofList extends App {

  def scaleListPM(xs: List[Double], factor: Double): List[Double] = xs match {
    case Nil => xs
    case y :: ys => y * factor :: scaleList(ys, factor)
  }

  def scaleList(xs: List[Double], factor: Double): List[Double] = xs map (_ * factor)

  def squareListPM(xs: List[Double]): List[Double] = xs match {
    case Nil => xs
    case y :: ys => y * y :: squareListPM(ys)
  }

  def squareList(xs: List[Double]): List[Double] = xs map (x => x * x)

  def positiveElemsPM(xs: List[Double]): List[Double] = xs match {
    case Nil => xs
    case y :: ys => if (y > 0) y :: positiveElemsPM(ys) else positiveElemsPM(ys)
  }

  def positiveElems(xs: List[Double]): List[Double] = xs filter (_ > 0)

  val nums = List(2, -2, 7, 0, 1, 8)
  val fruits = List("bananos", "peras", "aguacates", "manzanas", "mangos", "fresas", "naranjas")
  val aList = List("a", "a", "a", "b", "c", "c", "a")

  println(nums filter (_ > 0))
  println(nums filterNot (_ > 0))
  println(nums partition (_ > 0)) // The 2 above but in a single traversal

  println(nums takeWhile (_ > 0))
  println(nums dropWhile (_ > 0))
  println(nums span (_ > 0)) // The 2 above but in a single traversal

  def packList[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case y :: ys =>
      val (first, rest) = xs span (z => z == y)
      first :: packList(rest)
  }

  println(packList(aList))

  def encodeList[T](xs: List[T]): List[(T, Int)] = packList(xs) map (ys => (ys.head, ys.length))

  println(encodeList(aList))
}
