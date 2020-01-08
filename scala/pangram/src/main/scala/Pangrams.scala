object Pangrams {

  private val chars = ('a' to 'z').toSet

  def isPangram(input: String): Boolean = {
    (chars -- input.toLowerCase.toSet).isEmpty
  }
}

