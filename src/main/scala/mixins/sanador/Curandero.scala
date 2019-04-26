package mixins.sanador

import mixins.Personaje

trait Curandero extends Personaje {

  def curar(personaje: Personaje): Unit = {
     personaje.recibirCuracion(this.puntosACurar())
  }

  def puntosACurar(): Int = 2

}
