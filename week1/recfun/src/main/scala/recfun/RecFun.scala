package recfun

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

    case class Term(char: Char) {
      def isOpen: Boolean = char == '('

      def isClose: Boolean = char == ')'
    }

    object Parentheses {

      import scala.collection.mutable

      private val stack: mutable.Stack[Char] = mutable.Stack()

      def matches(term: Term): Int = {
        if (term.isOpen) {
          stack.push('(')
          1
        }
        else if (term.isClose) {
          if (stack.nonEmpty) stack.pop
          -1
        }
        else 0
      }

      def isBalanced(counter: Int): Boolean = counter == 0 && stack.isEmpty
    }

    @scala.annotation.tailrec
    def loop(chars: List[Char], counter: Int = 0): Boolean = {
      if (chars.isEmpty) Parentheses.isBalanced(counter)
      else loop(chars.tail, counter + Parentheses.matches(Term(chars.head)))
    }

    loop(chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {

    money match {
      case 0 => 1
      case money if money < 0 || (money >= 1 && coins.isEmpty) => 0
      case _ => countChange(money, coins.tail) + countChange(money - coins.head, coins)
    }
  }
}
