package Lab2

trait Nauczyciel extends Pracownik {
  override def podatek: Double = _pensja * 0.1
}