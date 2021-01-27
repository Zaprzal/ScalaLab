package Lab9

trait Maybe [+A]{
//  Zadanie 3
  def applyFunction[R](change: A => R): Maybe[R]
//  Zadanie 4
  def getOrElse[R >: A](defaultValue: => R) : R
}
