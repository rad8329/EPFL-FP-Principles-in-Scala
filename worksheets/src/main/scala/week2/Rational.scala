package week2

class Rational(x: Int, y: Int) {

  require(y != 0, "The denominator must be nonzero")

  def this(x: Int) = this(x, 1)

  @scala.annotation.tailrec
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def add(that: Rational) = new Rational(numer * that.denom + denom * that.numer, denom * that.denom)

  def +(that: Rational): Rational = add(that)

  def neg(that: Rational) = new Rational(-that.numer, that.denom)

  def unary_- : Rational = new Rational(-numer, denom)

  def sub(that: Rational): Rational = add(neg(that))

  def -(that: Rational): Rational = this + -that // for instance of how to

  def less(that: Rational): Boolean = numer * that.denom < that.numer * denom

  def <(that: Rational): Boolean = less(that)

  def max(that: Rational): Rational = if (this.less(that)) that else this

  override def toString: String = {
    val gcd = this.gcd(numer, denom)

    numer / gcd + " / " + denom / gcd
  }

  val numer = x
  val denom = y
}