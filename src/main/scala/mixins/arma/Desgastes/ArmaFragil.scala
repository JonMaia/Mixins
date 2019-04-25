package mixins.arma.Desgastes

import `object`.MansionesUtils
import clases.Arma

trait ArmaFragil extends Arma {
  override def danio(): Double = {
    if(!chancesDeNoFuncionar()) {
      super.danio()
    } else {
      0
    }
  }

  def chancesDeNoFuncionar() :Boolean = {
    var chances = MansionesUtils.randomIntBetween(0, 19)

   chances == 19
  }
}

