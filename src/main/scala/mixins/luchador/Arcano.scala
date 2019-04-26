package mixins.luchador

import `object`.MansionesUtils
import clases.{Investigador, Monstruo}
import mixins.Personaje

trait Arcano extends Monstruo {

  override def oponente(): Personaje = {
    this.habitacion.investigadorConMenosCordura()
  }

  override def danio(): Double = {
    calcularDanio()
  }

  def calcularDanio(): Double = {
    var corduraInicial = habitacion.investigadores().map(investigador => investigador.corduraInicial).sum
    var corduraActual = habitacion.investigadores().map(investigador => investigador.corduraActual).sum
    var danioArcano = corduraInicial - corduraActual

    danioArcano
  }

  override def ocacionarHorror(investigador: Investigador): Unit = {

    if(MansionesUtils.randomIntBetween(1,4) == 4) {
      investigador.volverLoco()
    } else {
      super.ocacionarHorror(investigador)
    }
  }

}
