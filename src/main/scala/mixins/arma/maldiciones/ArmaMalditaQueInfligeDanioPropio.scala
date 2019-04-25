package mixins.arma.maldiciones

import clases.{Arma}

trait ArmaMalditaQueInfligeDanioPropio extends Arma{

  override def danio(): Double = {
    investigador.recibirDanio(1)
    super.danio()
  }

}
