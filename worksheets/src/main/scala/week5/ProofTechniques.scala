package week5

object ProofTechniques {

  /**
   * Recall the concatenation operation "++"
   *
   * (xs ++ ys) ++ zs = xs ++ (ys ++ zs)
   * xs ++ Nil = xs
   * Nil ++ xs = xs
   *
   * --------------------
   * Structural Induction
   */

  def concat[T](firstList: List[T], secondList: List[T]): List[T] = firstList match {
    case Nil => secondList
    case head :: tail => head :: concat(tail, secondList)
  }

  // No way to follow Mr.Odersky
}
