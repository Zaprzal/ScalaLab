package Lab2


trait Pracownik extends Osoba {
  var _pensja = 0
  override val _podatek: Double = _pensja*0.2
}
