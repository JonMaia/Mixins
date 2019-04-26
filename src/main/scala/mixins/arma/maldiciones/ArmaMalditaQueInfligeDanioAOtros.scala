package mixins.arma.maldiciones

import clases.Arma

trait ArmaMalditaQueInfligeDanioAOtros extends Arma{

  override def danio(): Double = {

    daniarALosDemasInvestigadores()
    super.danio()

  }

  def daniarALosDemasInvestigadores(): Unit = {
    personaje.habitacion.investigadores().filter(investigador =>investigador != this.personaje)
      .foreach(investigador => investigador.recibirDanio(super.danio() * 0.1))
  }

}
