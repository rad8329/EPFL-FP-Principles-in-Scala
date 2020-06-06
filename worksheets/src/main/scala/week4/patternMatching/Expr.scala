package week4.patternMatching

trait Expr {

  def eval: Int = this match {
    case Number(n) => n
    case Sum(left, right) => left.eval + right.eval
    case noPattern => throw new Error(s"No pattern matched for ${noPattern.getClass.getSimpleName}")
  }

  def show: String = this match {
    case Number(n) => n.toString
    case Sum(left, right) => s"${left.show} + ${right.show}"
    case noPattern => throw new Error(s"No pattern matched for ${noPattern.getClass.getSimpleName}")
  }
}

case class Number(n: Int) extends Expr

case class Sum(left: Expr, right: Expr) extends Expr

case class Prod(left: Expr, right: Expr) extends Expr

object Number { //Companion object for Number
  def apply(n: Int): Number = new Number(n)
}

object Sum { //Companion object for Sum
  def apply(left: Expr, right: Expr): Sum = new Sum(left, right)
}

object Prod { //Companion object for Prod
  def apply(left: Expr, right: Expr): Prod = new Prod(left, right)
}

object exprTest extends App {

  val sumExpr = Sum(Sum(Number(5), Number(5)), Number(3))

  println(sumExpr.show)
  println(sumExpr.eval)

  val prodExpr = Prod(Sum(Number(5), Number(5)), Number(3))

  println(prodExpr.eval) //An exception is thrown
}