package mixins.arma

import clases.Arma

trait ArmaDeFuego extends Arma{

  var danioArmaDeFuego: Double = _

  override def danio(): Double = {
    this.danioArmaDeFuego
  }
  
}
