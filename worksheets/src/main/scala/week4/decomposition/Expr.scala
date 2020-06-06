package week4.decomposition

// OO decomposition example

trait Expr {
  def eval: Int
}

class Number(n: Int) extends Expr {
  override def eval: Int = n
}

class Sum(left: Expr, right: Expr) extends Expr {
  override def eval: Int = left.eval + right.eval
}

object exprTest extends App {

  val expr = new Sum(new Sum(new Number(5), new Number(5)), new Number(3))

  println(expr.eval)
}