package week5

object MoreFunctionsOnList extends App {
  // An a List is linear data structure
  // The fundamental operation is "head" and "tail"
  @scala.annotation.tailrec
  def last[T](xs: List[T]): T = xs match {
    case Nil => throw new Error("Last of empty list")
    case List(x) => x
    case y :: ys => last(ys)
  }

  def init[T](xs: List[T]): List[T] = xs match {
    case Nil => throw new Error("init of empty list")
    case List(x) => Nil
    case y :: ys => y :: init(ys)
  }

  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case Nil => ys
    case z :: zs => z :: concat(zs, ys)
  }

  def reverse[T](xs: List[T]): List[T] = xs match {
    case Nil => xs
    case y :: ys => reverse(ys) ++ List(y) // O(n^2) :)
  }

  def removeAt[T](xs: List[T], n: Int): List[T] = (xs take n) ::: (xs drop n + 1)

  val fruits = List("apples", "oranges", "pears")
  val nums = List(1, 2, 3)
  val diag3 = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
  val empty = List() // Same that Nil

  println(removeAt(fruits, 1))
  println(removeAt(diag3, 2))
}
