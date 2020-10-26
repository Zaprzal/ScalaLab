package Lab1

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object Code1 {
  def main(args : Array[String]){
    
    var dayList = List("Poniedzialek" , "Wtorek" , "Sroda" , "Czwartek" , "Piatek" , "Sobota" , "Niedziela")

    // petla for
    println("Petla for")
    println("-----------")
    for(i <- dayList){
      println(i)
    }
    println("-----------")
    println("Petla for z dniami na P")
    println("-----------")
    for(i <- dayList){
      if(i.startsWith("P"))
        println(i)
    }
    println("-----------")
    println("Petla while")
    println("-----------")

    var k = 0
    while(k < dayList.length){
      println(dayList(k))
      k += 1
    }
    println("-----------")
    println("Zadanie 2 - Funkcja rekurencyjna")
    println("-----------")

    def wypiszTab(lista: List[String] , indeks: Int = 0): String ={

      if(indeks < lista.length-1){
        return lista(indeks) + ", " + wypiszTab(lista , indeks+1)
      } else return  lista(indeks)
    }

    var dni_po_kolei = wypiszTab(dayList , 0 )
    println(dni_po_kolei)

    println("-----------")
    println("Zadanie 2 - Funkcja rekurencyjna od końca")
    println("-----------")

    def wypiszTabOdKonca(lista: List[String] , indeks: Int = 0): String ={
      if(indeks > 0){
        return lista(indeks) + ", " + wypiszTabOdKonca(lista , indeks-1)
      } else return  lista(indeks)
    }

    var dni_od_konca = wypiszTabOdKonca(dayList , dayList.length-1)
    println(dni_od_konca)

    println("-----------")
    println("Zadanie 3 - rekurencja ogonowa")

    def wypiszTabRek(tab: List[String]):String = {
      @tailrec
      def iter(tab: List[String], i: Int , result: String):String = {
        if(i == tab.size-1)
          result + tab(i)
        else iter(tab , i+1 , result + tab(i) + ", ")
      }
      iter(tab , 0 , "")
    }

    println(wypiszTabRek(dayList))

    println("-----------")
    println("Zadanie 4 - fold")
    println("-----------")

    println(dayList.foldLeft("")(_ + _+ ", " ))
    println(dayList.foldRight("")(_ + ", " + _))
    println(dayList.foldRight("\n") { (element, input) => if (element.startsWith("P")) input + element+ ", " else input })

    println("-----------")
    println("Zadanie 5 - Mapowanie")
    println("-----------")

    val mapaProduktow: Map [String, Double] = Map("Spodnie" -> 89.5 , "Bluza L" -> 41 , "Koszulka XYZ"  -> 98)
    println(mapaProduktow)
    println(mapaProduktow.map(x =>( x._1 ,x._2 * 0.9)))

    println("-----------")
    println("Zadanie 6 - Krotka")
    println("-----------")

    def wypiszKrotke(krotka: Tuple3[String , Int ,Double]): Unit ={

      val (produkt , wartosc , mnoznik) = krotka
      println(s"Produkt: $produkt wartość: $wartosc mnożnik: $mnoznik")

    }

    val tuple3 =  Tuple3("PEX" , 1 , 1.5)
    wypiszKrotke(tuple3)

    println("-----------")
    println("Zadanie 7 - Option")
    println("-----------")

    val cenabluzy : Option[Double] = mapaProduktow.get("Bluza XL")
    println("Cena Bluzy L: " + cenabluzy.getOrElse("nieznana"))

    println("-----------")
    println("Zadanie 8")
    println("-----------")
    val listaZZerami = List(0,0,9,4,1,4,7,0,3,0,9,9,7,0)
    def listbezzer(list: List[Int]): List[Int] ={
      var newList = new ListBuffer[Int]()
      list.foreach(x => if(x!= 0) newList+=x)
      return  newList.toList
    }
    println(listbezzer(listaZZerami))
    println("-----------")
    println("Zadanie 9")

    def zwiekszliste(list: List[Int]): List[Int] ={
      return list.map(_+1)
    }

    val listazwiekszona = zwiekszliste(listaZZerami)
    println(s"Lista przed zwiekszeniem $listaZZerami, lista po zwiekszeniu $listazwiekszona")
    println("-----------")
    println("Zadanie 10")

    val listaDoFiltrowania = List(-9, -1,2,15,-10,20,5,-3,12,-5,1,2,3,4)

    def filterList(list: List[Int]): List[Int]={
      return list.filter(x => x >= -5 && x <= 12)
    }

    val listapofiltrowaniu = filterList(listaDoFiltrowania)

    println(s"Lista przed filtrowaniem $listaDoFiltrowania, lista po filtorwaniu $listapofiltrowaniu")
    println("-----------")
  }
}
