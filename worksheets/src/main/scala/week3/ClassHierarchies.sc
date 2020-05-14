
abstract class IntSet {
  def incl(x: Int): IntSet

  def contains(x: Int): Boolean

  def union(other: IntSet): IntSet
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  override def incl(x: Int): NonEmpty = {

    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  }

  override def contains(x: Int): Boolean = {
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }

  override def toString: String = "{" + left + elem + right + "}"

  override def union(other: IntSet) = {
    ((left union right) union other) incl elem
  }
}

object Empty extends IntSet {
  override def incl(x: Int) = new NonEmpty(x, Empty, Empty)

  override def contains(x: Int) = false

  override def toString: String = "."

  override def union(other: IntSet) = other
}

val tree1 = new NonEmpty(2, Empty, Empty)
val tree2 = tree1 incl 1
val tree3 = new NonEmpty(3, Empty, Empty)
val tree4 = tree2.union(tree3)