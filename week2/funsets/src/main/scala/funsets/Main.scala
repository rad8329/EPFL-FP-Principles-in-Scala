package funsets

object Main extends App {

  import FunSets._

  val s1 = (x: Int) => x >= 10 && x <= 20
  val s2 = (x: Int) => x >= 12 && x <= 14

  printSet(s1)
  printSet(s2)

  printSet(union(s1, s2))
  printSet(diff(s1, s2))
}
