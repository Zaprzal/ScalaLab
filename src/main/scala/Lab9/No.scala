package Lab9

case class No() extends Maybe[Nothing]{
//  Zadanie 3
  override def applyFunction[R](change: Nothing => R): Maybe[R] = No()
//  Zadanie 4
  override def getOrElse[R >: Nothing](value: => R): R = value
}
