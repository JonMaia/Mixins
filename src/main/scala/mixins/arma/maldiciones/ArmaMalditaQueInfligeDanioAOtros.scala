package mixins.arma.maldiciones

import clases.Arma

trait ArmaMalditaQueInfligeDanioAOtros extends Arma{

  override def danio(): Double = {

    daniarALosDemasInvestigadores()
    super.danio()

  }

  def daniarALosDemasInvestigadores(): Unit = {
    var investigadores = investigador.habitacion.investigadores().filter(investigador => this.investigador != investigador)
    investigadores.foreach(investigador => investigador.recibirDanio(super.danio() * 0.1))
  }

}
