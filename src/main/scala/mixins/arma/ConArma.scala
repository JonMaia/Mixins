package mixins.arma

import clases.{Arma, Investigador}

trait ConArma extends Investigador {

  var arma :Arma = _

  def equiparArma(unArma :Arma): Unit = {
    unArma.cargarInvestigador(this)
    this.arma = unArma
  }

  override def danio(): Double = {
    this.arma.danio() // + super.danio       en caso de que se le sume el danio del investigador
  }
}
