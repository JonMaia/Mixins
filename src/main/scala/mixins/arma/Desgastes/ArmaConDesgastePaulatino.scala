package mixins.arma.Desgastes

import clases.Arma

trait ArmaConDesgastePaulatino extends Arma {
  var pocentajeDeAtaque :Double = 1

  override def danio(): Double = {
    if(this.pocentajeDeAtaque > 0.6) {
      var danioPaulatino = super.danio() * this.pocentajeDeAtaque

      decrementarPorcentajeDeAtaque()
      danioPaulatino
    } else {
      super.danio() * this.pocentajeDeAtaque
    }
  }

  def decrementarPorcentajeDeAtaque(): Unit = {
      this.pocentajeDeAtaque -= 0.1

  }
}
