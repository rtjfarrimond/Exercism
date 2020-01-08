object FlattenArray {

  def flatten[A](list: List[A]): List[Int] = {
    list.foldRight(List[Int]()) { (head, tail) =>
      head match {
        case i: Int => i :: flatten(tail)
        case as: List[A] => flatten(as) ::: flatten(tail)
        case _ => flatten(tail)
      }
    }
  }
}