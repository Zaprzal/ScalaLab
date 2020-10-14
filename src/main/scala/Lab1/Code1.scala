package Lab1

object Code1 {
  def main(args : Array[String]){
    println("Zadanie 2")
    println("---------")

    var listaDni = List("Poniedzialek" ,"Wtorek" , "Sroda" , "Czwartek" , "Piatek" , "Sobota" , "Niedziela")


    def wypiszTab(lista: List[String] , indeks: Int = 0): Unit ={
      var slowo: String = ""
      if(indeks == 0) {
        slowo = lista(indeks)
      }else {
        slowo = ", " + lista(indeks)
      }
        slowo = slowo + wypiszTab(lista , indeks+1)
        return  slowo
    }
    var cos = wypiszTab(listaDni , 0 )
    println(cos)
  }
}
