package mixins.arma.maldiciones

import clases.Arma

trait ArmaMalditaQueInfligeDanioAOtros extends Arma{

  override def danio(): Double = {

    this.daniarALosDemasInvestigadores()
    super.danio()

  }

  def daniarALosDemasInvestigadores(): Unit = {
    investigador.habitacion.investigadores().foreach(investigador => investigador.recibirDanio(super.danio() * 0.1))
  }

}
