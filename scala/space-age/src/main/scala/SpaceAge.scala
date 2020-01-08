object Planet extends Enumeration {

  protected case class Val(period: Double) extends super.Val {

    val eartOrbitalPeriodInSeconds = 31557600.0

    def spaceAge(seconds: Long): Double = {
      seconds / eartOrbitalPeriodInSeconds / period
    }

  }

  implicit def valueToPlanetVal(x: Value): Val = x.asInstanceOf[Val]

  val Mercury = Val(0.2408467)
  val Venus = Val(0.61519726)
  val Earth = Val(1.0)
  val Mars = Val(1.8808158)
  val Jupiter = Val(11.862615)
  val Saturn = Val(29.447498)
  val Uranus = Val(84.016846)
  val Neptune = Val(164.79132)
}


object SpaceAge {
  def onEarth(seconds: Long): Double = Planet.Earth.spaceAge(seconds)
  def onMercury(seconds: Long): Double = Planet.Mercury.spaceAge(seconds)
  def onVenus(seconds: Long): Double = Planet.Venus.spaceAge(seconds)
  def onMars(seconds: Long): Double = Planet.Mars.spaceAge(seconds)
  def onJupiter(seconds: Long): Double = Planet.Jupiter.spaceAge(seconds)
  def onSaturn(seconds: Long): Double = Planet.Saturn.spaceAge(seconds)
  def onUranus(seconds: Long): Double = Planet.Uranus.spaceAge(seconds)
  def onNeptune(seconds: Long): Double = Planet.Neptune.spaceAge(seconds)

  def onEarth(seconds: Double): Double = Planet.Earth.spaceAge(seconds.toLong)
  def onMercury(seconds: Double): Double = Planet.Mercury.spaceAge(seconds.toLong)
  def onVenus(seconds: Double): Double = Planet.Venus.spaceAge(seconds.toLong)
  def onMars(seconds: Double): Double = Planet.Mars.spaceAge(seconds.toLong)
  def onJupiter(seconds: Double): Double = Planet.Jupiter.spaceAge(seconds.toLong)
  def onSaturn(seconds: Double): Double = Planet.Saturn.spaceAge(seconds.toLong)
  def onUranus(seconds: Double): Double = Planet.Uranus.spaceAge(seconds.toLong)
  def onNeptune(seconds: Double): Double = Planet.Neptune.spaceAge(seconds.toLong)
}
