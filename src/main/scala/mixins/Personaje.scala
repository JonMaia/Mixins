package mixins

import clases.Habitacion

trait Personaje {

  var vida: Double
  var habitacion :Habitacion = _

  def recibirDanio(danio: Double): Unit = {
    this.vida -= danio
    if(vida <= 0) {
      vida = 0
      habitacion.retirarPersonaje()
    }
  }

  def estaMuerto(): Boolean ={
    vida == 0
  }

  def entrarEnHabitacion(habitacion: Habitacion): Unit = {
    habitacion.agregarHabitante(this)
  }

  def recibirCuracion(curacion: Int): Unit = {
    this.vida += curacion
  }

}
