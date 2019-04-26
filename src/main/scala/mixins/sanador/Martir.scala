package mixins.sanador

import clases.Investigador
import mixins.Personaje

trait Martir extends Personaje {

  def curar(investigador: Investigador): Unit = {
    investigador.recuperarCordura(puntosACurar())
  }

  def puntosACurar(): Int = {
    val puntos: Int = 4
    this.recibirDanio(puntos/2)
    return puntos
  }

}
