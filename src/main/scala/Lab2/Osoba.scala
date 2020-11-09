package Lab2

case class Osoba (imie: String , nazwisko: String){

  private val Imie: String = imie
  private val Nazwisko: String = nazwisko


  def imie_i_nazwisko: String = imie + " " + nazwisko
}
