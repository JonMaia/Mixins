package mixins.sanador

import clases.Investigador

trait Martir extends Sanador {

  def curar(investigador: Investigador): Unit = {
    investigador.recuperarCordura(puntosACurar())
  }

  override def puntosACurar(): Int = {
    val puntos: Int = 4
    this.recibirDanio(puntos/2)
    return puntos
  }

}
