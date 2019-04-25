package mixins.arma.maldiciones

import clases.Arma

trait ArmaMalditaConDanioReducido extends Arma {

  override def danio(): Double = {
    super.danio() - 1
  }

}
