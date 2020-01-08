object Raindrops {
  private val FactorsMap = Map(3 -> "Pling", 5 -> "Plang", 7 -> "Plong")

  def convert(n: Int): String = {
    FactorsMap.filter(n % _._1 == 0).values.mkString match {
      case "" => n.toString
      case s => s
    }
  }
}

