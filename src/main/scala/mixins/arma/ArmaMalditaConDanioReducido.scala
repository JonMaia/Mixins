package mixins.arma

import clases.Investigador

trait ArmaMalditaConDanioReducido extends Investigador{

  override def danio(): Double = {
    super.danio() - 1
  }

}
