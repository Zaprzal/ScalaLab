package Lab1

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
      var slowo: String = ""
      if(indeks == 0) {
        slowo = lista(indeks)
      }else {
        slowo = ", " + lista(indeks)
      }
      if(indeks < lista.length-1){
        return slowo + wypiszTab(lista , indeks+1)
      } else return  slowo
    }

    var dni_po_kolei = wypiszTab(dayList , 0 )

    println(dni_po_kolei)

    println("-----------")
    println("Zadanie 2 - Funkcja rekurencyjna od końca")
    println("-----------")

    def wypiszTabOdKonca(lista: List[String] , indeks: Int = 0): String ={
      var slowo: String = ""
      if(indeks == lista.length-1) {
        slowo = lista(indeks)
      }else {
        slowo = ", " + lista(indeks)
      }
      if(indeks > 0){
        return slowo + wypiszTabOdKonca(lista , indeks-1)
      } else return  slowo
    }
    var dni_od_konca = wypiszTabOdKonca(dayList , dayList.length-1 )

    println(dni_od_konca)
    println("-----------")

  }
}
