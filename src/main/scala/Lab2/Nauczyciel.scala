package Lab2

trait Nauczyciel extends Pracownik {
  override val _podatek: Double = _pensja * 0.1
}
