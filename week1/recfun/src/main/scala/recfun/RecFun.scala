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
      private var counter: Int = 0

      def open: Int = {
        counter += 1

        stack.push('(')

        counter
      }

      def close: Int = {
        counter -= 1

        if (stack.nonEmpty) stack.pop

        counter
      }

      def isBalanced: Boolean = counter == 0 && stack.isEmpty
    }

    @scala.annotation.tailrec
    def loop(chars: List[Char]): Boolean = {
      if (chars.isEmpty) Parentheses.isBalanced
      else {
        val term: Term = Term(chars.head)

        if (term.isOpen) Parentheses.open
        else if (term.isClose) Parentheses.close

        loop(chars.tail)
      }
    }

    loop(chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {

    money match {
      case 0 => 1
      case x if x < 0 || (x >= 1 && coins.isEmpty) => 0
      case _ => countChange(money, coins.tail) + countChange(money - coins.head, coins)
    }
  }
}
