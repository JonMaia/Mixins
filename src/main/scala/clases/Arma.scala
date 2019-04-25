package clases

import mixins.Personaje
import mixins.arma.ConArma

class Arma {
  var danioInicial :Double = _
  var investigador :Investigador = _

  def setDanio(unDanio :Double): Unit = {
    this.danioInicial = unDanio
  }

  def danio() :Double = {
    this.danioInicial
  }

  def cargarInvestigador(unInvestigador :Investigador): Unit = {
    this.investigador = unInvestigador
  }

}

