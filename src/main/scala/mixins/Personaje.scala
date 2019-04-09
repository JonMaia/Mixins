package mixins

import clases.Habitacion

trait Personaje {
  var vida :Int
  var habitacion :Habitacion = _

  def recibirDanio(danio :Int): Unit = {
    this.vida -= danio
  }

}
