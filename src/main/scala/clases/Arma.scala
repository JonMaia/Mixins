package clases

import mixins.Personaje

class Arma {
  var danioInicial :Double = _
  var personaje :Personaje = _

  def setDanio(unDanio :Double): Unit = {
    this.danioInicial = unDanio
  }

  def danio() :Double = {
    this.danioInicial
  }

  def cargarPersonaje(unPersonaje: Personaje): Unit = {
    this.personaje = unPersonaje
  }

}

