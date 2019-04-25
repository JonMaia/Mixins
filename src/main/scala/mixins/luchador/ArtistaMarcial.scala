package mixins.luchador

import clases.Investigador

/** Al atacar ocaciona un 50% más de daño. */
trait ArtistaMarcial extends Investigador {

  override def danio(): Double = super.danio() * 1.5

}
