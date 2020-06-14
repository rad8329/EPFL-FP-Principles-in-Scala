// Sets and Maps

/**
 * 1) The sets aren't ordered
 * 2) The sets of course doesn't have duplicated elements
 * 3) The fundamental operation is "contains"
 */

val fruit = Set("manzana", "banano", "pera")

val decimal = (0 to 9).toSet

// N-Queens

def queens(n: Int): Set[List[Int]] = {
  def isSafe(col: Int, queens: List[Int]): Boolean = {
    val row = queens.length
    val queensWithRow = (row - 1 to 0 by -1) zip queens

    queensWithRow forall {
      case (r, c) => col != c && math.abs(col - c) != row - r
    }
  }

  def placeQueen(k: Int): Set[List[Int]] =
    if (k == 0) Set(List())
    else
      for {
        queens <- placeQueen(k - 1)
        col <- 0 until n
        if isSafe(col, queens)
      } yield col :: queens

  placeQueen(n)
}

queens(4)