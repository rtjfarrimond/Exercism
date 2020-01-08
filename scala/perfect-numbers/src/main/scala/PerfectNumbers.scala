object NumberType extends Enumeration {
  val Perfect: NumberType.Value = Value
  val Abundant: NumberType.Value = Value
  val Deficient: NumberType.Value = Value
}

object PerfectNumbers {

  def classify(i: Int): Either[String, NumberType.Value] =
    if (i <= 0) Left("Classification is only possible for natural numbers.")
    else Right(matchType(i, factorize(i).sum))

  private def factorize(i: Int): Seq[Int] = {
    (1 to i / 2).flatMap { j =>
      if (i % j == 0) Some(j) else None
    }
  }

  private def matchType(i: Int, sumOfFactors: Int): NumberType.Value = sumOfFactors match {
    case j if j > i => NumberType.Abundant
    case j if j < i => NumberType.Deficient
    case _ => NumberType.Perfect
  }

}