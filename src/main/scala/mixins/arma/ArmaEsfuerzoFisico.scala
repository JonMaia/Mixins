package mixins.arma

import clases.Investigador
import mixins.Personaje

trait ArmaEsfuerzoFisico extends Investigador {

  override def danio(): Double = {
    this.vida * 1.5
  }


}
