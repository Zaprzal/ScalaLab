package Lab2

object Lab2 {

  def main(args : Array[String]): Unit ={


    println("Zadanie 1")
    def sprawdzenieDnia (x: String): String = x match{
      case "Poniedzialek" => "Praca"
      case "Wtorek" => "Praca"
      case "Sroda" => "Praca"
      case "Czwartek" => "Praca"
      case "Piatek" => "Praca"
      case "Sobota" => "Weekend"
      case "Niedziela" => "Weekend"
      case _ => "Nie ma takiego dnia!"
    }
    println(sprawdzenieDnia("Wtorek"))
    println(sprawdzenieDnia("Piatek"))
    println(sprawdzenieDnia("Niedziela"))
    println(sprawdzenieDnia("cos"))

    println("-------------------")
    println("Zadanie 2")

    val konto1 = new KontoBankowe()
    val konto2 = new KontoBankowe(2000)
    println("Sprawdzenie stanu kont po założeniu")
    println("Konto1 :"+konto1.stanKonta)
    println("Konto2 :"+konto2.stanKonta)
    println("Sprawdzenie stanu kont po wplacie")
    konto1.wplata(120.99)
    println("Konto1 :"+konto1.stanKonta)
    println("Konto2 :"+konto2.stanKonta)
    println("Sprawdzenie stanu kont po wyplacie")
    konto2.wyplata(923.22)
    println("Konto1 :"+konto1.stanKonta)
    println("Konto2 :"+konto2.stanKonta)

    println("-------------------")
    println("Zadanie 3")

    val osoba1 = new Osoba("Pawel" , "Nowak")
    val osoba2 = new Osoba("Pawel" , "Kowalski")
    val osoba3 = new Osoba("Pawel" , "Ziemniak")
    val osoba4 = new Osoba("Jan" , "Kowalski")
    val osoba5 = new Osoba("Jan" , "Nieznajomy")

    def powitaj(x: Osoba): String= x match {
      case Osoba("Pawel" , "Nowak") => "Dzień dobry Panie Profesorze!"
      case Osoba("Pawel" , "Kowalski") => "Siema Pawel"
      case Osoba("Pawel" , "Ziemniak") => "Miło Cię widzieć Pawel"
      case Osoba("Jan" , "Kowalski") => "Witaj Janie!"
      case _ => "Witaj nieznajomy!"
    }
    println(powitaj(osoba1))
    println(powitaj(osoba2))
    println(powitaj(osoba3))
    println(powitaj(osoba4))
    println(powitaj(osoba5))
    println("-------------------")
    println("Zadanie 4")

    def funkcja(x: Int , fun: Int => Int): Int ={
      var value = x
      var i = 0
      while (i < 3){
        value+=fun(value)
        i+=1
      }
      return value
    }
    def mnoznik2 (x: Int): Int ={
      return x*2
    }
    println("Wartość początkowa = 2 , wartosc po uruchomieni funkcji = " + funkcja(3 , mnoznik2))
    println("-------------------")
    println("Zadanie 5")
    var student = new Osoba2 with Student
    var pracownik = new Osoba2 with Pracownik
    pracownik._pensja = 2000
    var pracownik2 = new Osoba2 with Pracownik with Nauczyciel
    pracownik2._pensja = 2000
    println(student.podatek)
    println(pracownik.podatek)
    println(pracownik2.podatek)
  }
}
