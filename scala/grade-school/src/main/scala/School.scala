class School {
  type DB = Map[Int, Seq[String]]

  private var dbMap: Map[Int, Seq[String]] = Map()

  def add(name: String, g: Int): Unit = {
    val names: Seq[String] = db.getOrElse(g, Seq())
    dbMap = db + (g -> (names ++ Seq(name)))
  }

  def db: DB = dbMap

  def grade(g: Int): Seq[String] = db.getOrElse(g, Seq())

  def sorted: DB = dbMap.toSeq.sortBy(_._1).map {
    case (grade, names) => (grade, names.sorted)
  }.toMap
}
