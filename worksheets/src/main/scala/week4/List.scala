package week4

trait List[+T] {
  def isEmpty: Boolean

  def head: T

  def tail: List[T]

  //def prepended(elem: T): List[T] = new Cons(elem, this) // This yield a compile error because the variant checking
  def prepended[U >: T](elem: U): List[U] = new Cons(elem, this)
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = true
}

object Nil extends List[Nothing] {
  override def isEmpty: Boolean = true

  override def head: Nothing = throw new NoSuchElementException("Nil.head")

  override def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object listTest extends App {
  val x: List[String] = Nil // Is correct because Nil is a list of nothing, and nothing is a subtype o string

  def f(xs: List[NonEmpty], x: Empty): List[IntSet] = xs prepended x
}