package mixins.arma

import clases.Investigador

trait ArmaMalditaQueInfligeDanioAOtros extends Investigador{

  override def danio(): Double = {

    this.daniarALosDemasInvestigadores(super.danio())
    super.danio()

  }

  def daniarALosDemasInvestigadores(danio: Double): Unit = {
    habitacion.investigadores().foreach(investigador => investigador.recibirDanio(danio * 0.1))
  }

}
