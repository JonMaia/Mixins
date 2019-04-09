package clases

import mixins.Personaje

class Habitacion {
  var personajes :List[Personaje] = List()

  def agregarHabitante(personaje: Personaje) = {
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

}
