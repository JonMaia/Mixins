package clases

import mixins.{Luchador, Personaje}
import scala.util.Random

class Investigador(vidaInicial :Int) extends Personaje with Luchador {
  override var vida: Int = vidaInicial

  override def danio(): Int = {
    Random.nextInt(vida - 1) + 1
  }

  override def atacar(): Unit = {
    habitacion.monstruoMasPoderoso().recibirDanio(danio())
  }
}
