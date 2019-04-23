package mixins.luchador

import clases.{Investigador, Monstruo}

trait Bestia extends Monstruo with Luchador {

  override def atacar(): Unit = {
    val masDebil = habitacion.investigadores().min(Ordering.by((investigador: Investigador) => investigador.vida))
    masDebil.recibirDanio(danio())
  }

  override def danio(): Double = {
    habitacion.monstruos().size
  }

}
