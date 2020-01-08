object ArmstrongNumbers {
  def isArmstrongNumber(n: Int): Boolean = {
    val digits = n
      .toString
      .toCharArray
      .map(_.asDigit)
    digits.map(math.pow(_, digits.length)).sum == n
  }
}