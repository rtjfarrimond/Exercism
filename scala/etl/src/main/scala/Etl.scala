object Etl {

  def transform(extracted: Map[Int, Seq[String]]): Map[String, Int] = {
    for {
      (score, letters) <- extracted
      l <- letters
    } yield l.toLowerCase -> score
  }

}