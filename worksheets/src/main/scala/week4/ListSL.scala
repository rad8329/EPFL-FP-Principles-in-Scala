package week4

// This is important because the current package already have a "List" class

import scala.collection.immutable.List
import scala.collection.immutable.Nil

object ListSL extends App {
  //val fruits: List[String] = List("apples", "oranges", "pears")
  val fruits: List[String] = "apples" :: ("oranges" :: ("pears" :: Nil)) // :: is the construction operation


  //val nums: List[Int] = List(1, 2, 3, 4)
  val nums: List[Int] = 1 :: 2 :: 3 :: 4 :: Nil // can omit the parentheses

  val diag3: List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
  val empty: List[Nothing] = List()

  println(nums)
}
