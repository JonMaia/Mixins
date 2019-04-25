package mixins.arma.Desgastes

import clases.Arma

trait ArmaDesgastable extends Arma {
  var usos :Int = _

  def setUsos(nUsos :Int): Unit = {
    this.usos = nUsos + 1
  }

  // Decrementa en 1 los usos del arma
  def desgastar(): Unit = {
    if(this.usos > 0) {
      this.usos -= 1
    } else {
      this.usos = 0
    }

  }

  def estaDesgastada() :Boolean = {
    this.usos == 0
  }

  override def danio(): Double = {
    desgastar()
    if(!estaDesgastada()) {
      super.danio()
    } else {
      0
    }
  }
}
