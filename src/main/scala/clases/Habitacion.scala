package clases

import mixins.Personaje

class Habitacion {
  var personajes :List[Personaje] = List()

  def agregarHabitante(personaje: Personaje): Unit = {
    personaje.habitacion = this
    personajes = personajes :+ personaje
  }

  def investigadores() :List[Investigador] = {
    personajes.collect({ case personaje: Investigador => personaje})
  }

  def monstruos() :List[Monstruo] = {
    personajes.collect{ case personaje: Monstruo => personaje}
  }

  // Retorna al monstruo con más puntos de vida que esta en la habitación.
  def monstruoMasPoderoso(): Monstruo = {
    monstruos().maxBy(monstruo => monstruo.vida)
  }

  def retirarPersonaje(): Unit = {
    personajes = personajes.filterNot(p => p.estaMuerto())
  }

  def investigadorConMenosCordura(): Investigador = {
    investigadores().minBy(investigador => investigador.corduraActual)
  }

  def investigadorMasPoderoso(): Investigador = {
    investigadores().maxBy(investigador => investigador.vida)
  }
}
