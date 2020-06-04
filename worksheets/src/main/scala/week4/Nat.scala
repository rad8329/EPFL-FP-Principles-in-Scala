package week4

// The Peano numbers
abstract class Nat {
  def isZero: Boolean

  def predecessor: Nat

  def successor: Nat = new Succ(this)

  def +(that: Nat): Nat

  def -(that: Nat): Nat
}

object Zero extends Nat {
  override def isZero: Boolean = true

  override def predecessor: Nat = throw new Error("0 don't have a predecessor")

  override def successor: Nat = new Succ(this)

  def +(that: Nat): Nat = that

  def -(that: Nat): Nat = if (that.isZero) this else throw new Error("Out of boundaries of naturals numbers set")
}

class Succ(n: Nat) extends Nat {
  override def isZero: Boolean = false

  override def predecessor: Nat = n

  override def successor: Nat = new Succ(this)

  def +(that: Nat): Nat = new Succ(n + that)

  def -(that: Nat): Nat = if (that.isZero) this else n - that.predecessor
}