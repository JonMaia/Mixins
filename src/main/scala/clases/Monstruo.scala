package clases

import mixins.Personaje
import mixins.luchador.Luchador

class Monstruo(vidaInicial :Int, var horror: Int = 1) extends Personaje with Luchador {

  override var vida: Int = vidaInicial

  //Propósito: cuando un mostruo ataca siempre ocaciona 1 de daño.
  override def danio(): Int = 1

  def ocacionarHorror(investigador: Investigador): Unit = {
    investigador.recibirHorror(this.horror)
  }

  override def entrarEnHabitacion(habitacion: Habitacion): Unit = {
    super.entrarEnHabitacion(habitacion)
    habitacion.investigadores().foreach(investigador => this.ocacionarHorror(investigador))
  }

  //Propósito: Selecciona al primer investigador, que se encuentre en la misma habitación que él, como oponente.
  override def oponente(): Personaje = {
    habitacion.investigadores().head
  }

}
