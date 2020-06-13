package week5

// More HoF of List
object ReductionOfList extends App {

  /*
  abstract class List[T] {
    def reduceLeft(operation: (T, T) => T): T = this match {
      case Nil => throw new Error("Nil.reduceLeft")
      case head :: tail => (tail foldLeft head)(operation)
    }

    def foldLeft[U](element: U)(operation: (U, T) => U): U = this match {
      case Nil => element
      case head :: tail => (tail foldLeft operation(element, head))(operation)
    }

    def reduceRight(operation: (T, T) => T): T = this match {
      case Nil => throw new Error("Nil.reduceRight")
      case head :: Nil => head
      case head :: tail => operation(head, tail.reduceRight(operation))
    }

    def foldRight[U](element: U)(operation: (T, U) => U): U = this match {
      case Nil => element
      case head :: tail => operation(head, (tail foldRight element)(operation))
    }
  }
  */

  // I prefer the meaningful var/val names
  def sumPM(numbers: List[Int]): Int = numbers match {
    case Nil => 0
    case head :: tail => head + sumPM(tail)
  }

  def productPM(numbers: List[Int]): Int = numbers match {
    case Nil => 1
    case head :: tail => head * productPM(tail)
  }

  def sum1(numbers: List[Int]): Int =
  //(0 :: numbers) reduceLeft ((x, y) => x + y)
    (0 :: numbers) reduceLeft (_ + _)

  def product1(numbers: List[Int]): Int = (1 :: numbers) reduceLeft (_ * _)

  def sum2(numbers: List[Int]): Int = (numbers foldLeft 0) (_ + _)

  def product2(numbers: List[Int]): Int = (numbers foldLeft 1) (_ * _)

  val nums = List(4, 4, 4, 4)

  println(sumPM(nums))
  println(sum1(nums))
  println(sum2(nums))

  println(productPM(nums))
  println(product1(nums))
  println(product2(nums))
}
