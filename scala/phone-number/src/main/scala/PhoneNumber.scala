object PhoneNumber {
  def clean(input: String): Option[String] = {
    validate(removeCountryCode(input.filter(_.isDigit)))
  }

  private def removeCountryCode(input: String): String = input.head match {
    case '1' => input.tail
    case _ => input
  }

  private def validate(withoutCountryCode: String): Option[String] = {
    if (withoutCountryCode.length != 10) None
    else validateAreaCode(withoutCountryCode).flatMap(_ => validateExchangeCode(withoutCountryCode))
  }

  private def validateAreaCode(withoutCountryCode: String): Option[String] = {
    validateNxx(withoutCountryCode take 3).map(_ => withoutCountryCode)
  }

  private def validateExchangeCode(withoutCountryCode: String): Option[String] = {
    validateNxx(withoutCountryCode slice(3, 6)).map(_ => withoutCountryCode)
  }

  private def validateNxx(nxx: String): Option[String] = nxx.head match {
    case c if c.asDigit > 1 => Some(nxx)
    case _ => None
  }
}