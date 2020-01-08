case class Matrix(private val stringRepresentation: String) {
  override val toString: String = stringRepresentation
  lazy val row: Seq[Vector[Int]] = toString.split('\n').map(_.split(' ').map(_.toInt).toVector)
  lazy val column: Seq[Vector[Int]] = row.transpose.map(_.toVector)
}