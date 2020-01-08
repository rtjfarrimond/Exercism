object SecretHandshake {

  private val Reverse = "reverse"
  private val codex = Seq(Reverse, "jump", "close your eyes", "double blink", "wink")

  def commands(input: Int): Seq[String] = {
    val binaryString = input.toBinaryString
    val paddedBinaryString = Seq.fill(codex.length - binaryString.length)('0') ++ binaryString
    val decoded = paddedBinaryString.zip(codex)
      .filter(_._1 == '1')
      .map(_._2)

    // Counterintuitively, we reverse if "reverse" is NOT present to meet requirements.
    if (!decoded.contains(Reverse)) decoded.reverse else decoded.filterNot(_ == Reverse)
  }
}