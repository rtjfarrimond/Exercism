import enumeratum._

sealed trait Bearing extends EnumEntry

case object Bearing extends Enum[Bearing] {

  case object North extends Bearing
  case object East extends Bearing
  case object South extends Bearing
  case object West extends Bearing

  val values = findValues

  def left(bearing: Bearing): Bearing = {
    val pos = values.indexOf(bearing) - 1
    if (pos == -1) values.last else values(pos)
  }

  def right(bearing: Bearing): Bearing = {
    val pos = values.indexOf(bearing) + 1
    if (pos == values.length) values.head else values(pos)
  }
}

case class Robot(bearing: Bearing, coordinates: (Int, Int)) {
  val x: Int = coordinates._1
  val y: Int = coordinates._2

  def simulate(instructions: String): Robot =
    instructions.foldLeft(this) {
      case (robot, instruction) => robot.execute(instruction)
    }

  private def execute(instruction: Char): Robot =
    instruction match {
      case 'L' => turnLeft
      case 'R' => turnRight
      case 'A' => advance
      case _ => throw new IllegalArgumentException(s"Invalid instruction '$instruction' passed.")
  }

  def advance: Robot =
    bearing match {
      case Bearing.North => Robot(bearing, (x, y + 1))
      case Bearing.East => Robot(bearing, (x + 1, y))
      case Bearing.South => Robot(bearing, (x, y - 1))
      case Bearing.West => Robot(bearing, (x - 1, y))
    }

  def turnLeft: Robot = Robot(Bearing.left(bearing), coordinates)
  def turnRight: Robot = Robot(Bearing.right(bearing), coordinates)

}