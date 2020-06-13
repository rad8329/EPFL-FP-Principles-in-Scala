package week4

// This is important because the current package already have a "List" class

import scala.collection.immutable.List
import scala.collection.immutable.Nil

// Standard Library List
object ListSL extends App {

  def matchList(list: List[Any]): List[Any] = list match {
    case 1 :: 2 :: xs => xs
    case x :: Nil => x match {
      case str: String => List(str.reverse) //Only if is a String
      case _ => List(x)
    }
    case List() => List(Nil) // An empty list within a list
    case x => x // The same List
  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  }

  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, isort(ys))
  }

  //val fruits: List[String] = List("apples", "oranges", "pears")
  val fruits: List[String] = "apples" :: ("oranges" :: ("pears" :: Nil)) // :: is the construction operation


  //val nums: List[Int] = List(1, 2, 3, 4)
  val nums: List[Int] = 1 :: 2 :: 3 :: 4 :: Nil // can omit the parentheses

  val diag3: List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))

  val single: List[String] = List("Hola")

  val empty: List[Nothing] = List()

  println(nums)
  println(matchList(single))
  println(matchList(List()))

  println(insert(4, empty))
  println(insert(-8, nums))
}
