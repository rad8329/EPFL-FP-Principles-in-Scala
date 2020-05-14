import week3._

@scala.annotation.tailrec
def nth[T](n: Int, list: List[T]): T =
  if (list.isEmpty) throw new IndexOutOfBoundsException(s"$n is out of bounds")
  else if (n == 0) list.head
  else nth(n - 1, list.tail)

val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))

nth(1, list)