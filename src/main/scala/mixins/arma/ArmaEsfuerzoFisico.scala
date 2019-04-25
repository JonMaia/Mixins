package mixins.arma

import clases.Arma

trait ArmaEsfuerzoFisico extends Arma  {

  override def danio(): Double = {
    this.investigador.vida * 1.5
  }

}
