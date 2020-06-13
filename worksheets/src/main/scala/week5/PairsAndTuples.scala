package week5

object PairsAndTuples extends App {

  // This is a method that isn't generic, but It's just for instance
  def mergeSort(xs: List[Int]): List[Int] = {

    // WTF, just go back to JS mess
    def mergeWithNestedPatternMatching(xs: List[Int], ys: List[Int]): List[Int] = xs match {
      case Nil => ys
      case z :: zs => ys match {
        case Nil => xs
        case w :: ws =>
          if (z < w)
            z :: mergeWithNestedPatternMatching(zs, ys)
          else
            w :: mergeWithNestedPatternMatching(xs, ws)
      }
    }

    //So readable now
    def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (z :: zs, w :: ws) => if (z < w) z :: merge(zs, ys) else w :: merge(xs, ws)
    }


    val n = xs.length / 2

    if (n == 0) xs
    else {

      val (left, right) = xs splitAt n

      merge(mergeSort(left), mergeSort(right))
    }
  }

  val nums = List(2, 7, -2, 0, 1, 8)

  println(mergeSort(nums))

  val aPair: (String, Int) = ("answer", 42)

  //val (label, value) = aPair // decomposing with pattern matching

  val label: String = aPair._1
  val value: Int = aPair._2
}
