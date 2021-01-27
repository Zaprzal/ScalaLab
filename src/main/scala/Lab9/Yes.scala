package Lab9

case class Yes[A](value: A)extends Maybe[A]{
//  Zadanie 3
  override def applyFunction[R](change: A => R): Maybe[R] = Yes(change(value))
//  Zadanie 4
  override def getOrElse[R >: A](value: => R): R = value
}
