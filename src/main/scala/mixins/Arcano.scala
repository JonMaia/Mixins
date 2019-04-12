package mixins

import `object`.MansionesUtils
import clases.{Investigador, Monstruo}

trait Arcano extends Monstruo {

  override def danio(): Int = {
    calcularDanio()
  }

  override def atacar(): Unit = {
    habitacion.investigadorConMenosCordura().recibirDanio(this.danio())
  }

  def calcularDanio(): Int = {
    var corduraInicial = habitacion.investigadores().map(investigador => investigador.corduraInicial).sum
    var corduraActual = habitacion.investigadores().map(investigador => investigador.corduraActual).sum
    var danioArcano = corduraInicial - corduraActual

    danioArcano
  }

  override def ocacionarHorror(investigador: Investigador): Unit = {

    if(MansionesUtils.randomIntBetween(0,3) == 0) {
      investigador.recibirHorror(investigador.corduraActual)
    } else {
      super.ocacionarHorror(investigador)
    }
  }

}
