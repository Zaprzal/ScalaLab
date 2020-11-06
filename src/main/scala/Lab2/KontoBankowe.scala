package Lab2

class KontoBankowe(val stanInicjalny: Double) {

  def this() = this(0)

  private var _stanKonta: Double = stanInicjalny

  def stanKonta : Double = this._stanKonta

  def wplata(wplacanaKwota: Double): Unit ={
    this._stanKonta += wplacanaKwota
  }
  def wyplata(wyplacanaKwota: Double): Unit ={
    this._stanKonta -= wyplacanaKwota
  }


}
