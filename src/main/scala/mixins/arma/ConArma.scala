package mixins.arma

import clases.{Arma, Investigador}

import mixins.Personaje

trait ConArma extends Personaje {

  var arma :Arma = _

  def equiparArma(unArma :Arma): Unit = {
    unArma.cargarPersonaje(this)
    this.arma = unArma
  }

  override def danio(): Double = {
    this.arma.danio() // + super.danio       en caso de que se le sume el danio del investigador
  }
}
