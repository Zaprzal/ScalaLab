package Lab9

object Lab9 {
  def main(args : Array[String]): Unit ={

    val yes = Yes()
    val no = No()

    println(yes.isInstanceOf[Maybe[_]])
    println(no.isInstanceOf[Maybe[_]])

  }

}
