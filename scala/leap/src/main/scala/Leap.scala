object Leap {
  def leapYear(year: Int): Boolean = {
    val isDivisibleByYear = isDivisibleBy(year)(_)
    isDivisibleByYear(4) & !isDivisibleByYear(100) || isDivisibleByYear(400)
  }

  private def isDivisibleBy(n: Int)(divisor: Int): Boolean = n % divisor == 0
}
