package recfun

import scala.collection.mutable

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(col: Int, row: Int): Int = {
    if (col < 0 && row < 0) 0
    else if (col >= row) 1
    else pascal(col - 1, row - 1) + pascal(col, row - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    @scala.annotation.tailrec
    def loop(chars: List[Char], stack: mutable.Stack[Char] = mutable.Stack()): Boolean = {
      if (chars.isEmpty) stack.isEmpty
      else {
        val head = chars.head

        if ('(' == head) loop(chars.tail, stack.push('('))
        else if (')' == head) {
          if (stack.nonEmpty) {
            stack.pop

            loop(chars.tail, stack)
          } else false
        }
        else loop(chars.tail, stack)
      }
    }

    loop(chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money < 0 || (money >= 1 && coins.isEmpty)) 0
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
}
