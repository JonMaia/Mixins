package mixins

import clases.Habitacion

trait Personaje {
  var vida :Int
  var habitacion :Habitacion = _

  def recibirDanio(danio :Int): Unit = {
    this.vida -= danio
    if(vida <= 0) {
      vida = 0
      habitacion.retirarPersonaje()
    }
  }

  def estaMuerto(): Boolean ={
    vida == 0
  }

}
