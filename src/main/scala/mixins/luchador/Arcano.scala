package mixins.luchador

import `object`.MansionesUtils
import clases.{Investigador, Monstruo}

trait Arcano extends Monstruo {

  override def danio(): Double = {
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
      investigador.recibirHorror(investigador.corduraActual) // funcion volver loco
    } else {
      super.ocacionarHorror(investigador)
    }
  }

}