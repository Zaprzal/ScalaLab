package Lab2

trait Pracownik extends Osoba2 {
  var _pensja = 0
  override def podatek: Double = _pensja * 0.2
}
