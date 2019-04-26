package clases

import mixins.{ConHorror, Personaje}
import mixins.luchador.Luchador


class Monstruo(vidaInicial :Int) extends Personaje with Luchador with ConHorror {

  override var vida: Double = vidaInicial

  //Propósito: cuando un mostruo ataca siempre ocaciona 1 de daño.
  override def danio(): Double = 1

  override def ocacionarHorror(investigador: Investigador): Unit = {
    investigador.recibirHorror(this.horror())
  }

  override def horror(): Int = 1


  override def entrarEnHabitacion(habitacion: Habitacion): Unit = {
    super.entrarEnHabitacion(habitacion)
    habitacion.investigadores().foreach(investigador => this.ocacionarHorror(investigador))
  }

  //Propósito: Selecciona al primer investigador, que se encuentre en la misma habitación que él, como oponente.
  override def oponente(): Personaje = {
    habitacion.investigadores().head
  }

  override def cantidadDeDanioPorHechizo(): Double = {
    1/this.vida
  }

}
