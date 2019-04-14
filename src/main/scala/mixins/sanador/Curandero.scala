package mixins.sanador

import mixins.Personaje

trait Curandero extends Sanador {

  override def curar(personaje: Personaje): Unit = {
    personaje.recibirCuracion(this.puntosACurar())
  }

  override def puntosACurar(): Int = 2

}
