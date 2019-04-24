package mixins.arma

import clases.Investigador

trait ArmaMalditaQueInfligeDanioPropio extends Investigador{

  override def danio(): Double = {
    super.recibirDanio(1)
    super.danio()
  }

}
