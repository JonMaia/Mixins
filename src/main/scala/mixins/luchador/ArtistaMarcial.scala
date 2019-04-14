package mixins.luchador

import `object`.MansionesUtils
import clases.Investigador

/** Al atacar ocaciona un 50% más de daño. */
trait ArtistaMarcial extends Investigador {

  override def danio(): Int = {

    if(MansionesUtils.state) {
      MansionesUtils.roundInt(MansionesUtils.danioControlable() * 1.5)
    } else {
      var danioPotenciado = super.danio() * 1.5

      MansionesUtils.roundInt(danioPotenciado)
    }

  }

}
