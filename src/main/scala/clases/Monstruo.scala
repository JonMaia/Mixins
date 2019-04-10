package clases

import mixins.{Luchador, Personaje}

class Monstruo(vidaInicial :Int, var horror: Int = 1) extends Personaje with Luchador {

  override var vida: Int = vidaInicial

  override def danio(): Int = 1

  override def atacar(): Unit = {
    habitacion.investigadores().head.recibirDanio(danio())
  }

  def ocacionarHorror(investigador: Investigador) = {
    investigador.recibirHorror(this.horror)
  }
}
