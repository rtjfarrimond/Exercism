object Response extends Enumeration {
  val Sure = "Sure."
  val ChillOut = "Whoa, chill out!"
  val CalmDown = "Calm down, I know what I'm doing!"
  val FineBeThatWay = "Fine. Be that way!"
  val Whatever = "Whatever."
}

object Bob {
  def response(statement: String): String = statement.trim match {
    case s if isShouting(s) && isQuestion(s) => Response.CalmDown
    case s if isQuestion(s) => Response.Sure
    case s if isShouting(s) => Response.ChillOut
    case "" => Response.FineBeThatWay
    case _ => Response.Whatever
  }

  private def isQuestion(s: String): Boolean = {
    s.endsWith("?")
  }

  private def isShouting(s: String): Boolean = {
    val filtered = filterNumbers(filterPunctuation(s))
    if (filtered == "") false else filtered.forall(_.isUpper)
  }

  private def filterPunctuation(s: String): String = {
    val charsString = "%^*@#$:)(*^!?, "
    s.filter(!charsString.contains(_))
  }

  private def filterNumbers(s: String): String =
    s.filter(!"0123456789".toCharArray.contains(_))
}
