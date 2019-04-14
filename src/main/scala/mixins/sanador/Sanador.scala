package mixins.sanador

import mixins.Personaje

trait Sanador extends Personaje {

  def curar(personaje: Personaje): Unit

  def puntosACurar(): Int

}
