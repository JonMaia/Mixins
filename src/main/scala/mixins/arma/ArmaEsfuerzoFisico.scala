package mixins.arma

import clases.Arma

trait ArmaEsfuerzoFisico extends Arma  {

  override def danio(): Double = {
    personaje.vida * 1.5
  }

}
