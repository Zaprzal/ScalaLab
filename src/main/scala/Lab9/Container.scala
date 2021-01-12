package Lab9

class Container [A] (value: A){
  private var _value: A = value
  def getContent: A = _value
  def applyFunction(value: A): Unit = {
    _value = value
  }
}
