object CollatzConjecture {
  def steps(init: Int): Option[Int] = {
    @scala.annotation.tailrec
    def loop(next: Int, steps: Int): Int = next match {
      case 1 => steps
      case i if i % 2 == 0 => loop(i / 2, steps + 1)
      case i if i % 2 == 1 => loop((3 * i) + 1, steps + 1)
    }
    if (init <= 0) None else Some(loop(init, 0))
  }
}