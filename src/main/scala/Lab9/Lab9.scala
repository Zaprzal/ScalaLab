package Lab9

object Lab9 {
  def main(args : Array[String]): Unit ={

    val no = new No() {}

    val yes = new Yes() {}

    println(no.isInstanceOf[Maybe])
    println(yes.isInstanceOf[Maybe])

  }

}
