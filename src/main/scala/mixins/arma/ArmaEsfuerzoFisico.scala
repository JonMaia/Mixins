package mixins.arma

import clases.Arma

trait ArmaEsfuerzoFisico extends Arma  {

  override def danio(): Double = {
    investigador.vida * 1.5
  }

}
