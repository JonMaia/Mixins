package mixins.arma.maldiciones

import clases.{Arma}

trait ArmaMalditaQueInfligeDanioPropio extends Arma{

  override def danio(): Double = {
    personaje.recibirDanio(1)
    super.danio()
  }

}
