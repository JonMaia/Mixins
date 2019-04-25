package mixins.arma

import clases.Arma

trait Hechizo extends Arma {

  var danioFijo : Double = _

  override def danio(): Double = {
    danioFijo*this.investigador.oponente().cantidadDeDanioPorHechizo()
  }

}
