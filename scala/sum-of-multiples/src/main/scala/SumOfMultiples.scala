object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
    val maybeFactors = for {
      i <- 1 until limit
      factor <- factors
      maybeFactor = if (i % factor == 0) Some(i) else None
    } yield maybeFactor
    maybeFactors.flatten.sum
  }
}

