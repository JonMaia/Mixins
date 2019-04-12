package clases

import mixins.{Luchador, Personaje, Sanador}

import scala.util.Random

class Investigador(vidaInicial: Int, val corduraInicial: Int) extends Personaje with Luchador with Sanador{

  var estaLoco: Boolean = false
  override var vida: Int = vidaInicial
  var corduraActual: Int = corduraInicial

  override def curar(personaje: Personaje): Unit = {
    personaje.recibirCuracion(this.puntosACurar())
  }

  override def puntosACurar(): Int = 0

  override def danio(): Int = {
    Random.nextInt(this.vida - 1) + 1
  }

  override def atacar(): Unit = {
    habitacion.monstruoMasPoderoso().recibirDanio(danio)
  }

  def getEstaLoco(): Boolean = {
    this.estaLoco
  }

  def getCorduraActual() = {
    this.corduraActual
  }

  def recibirHorror(horror: Int) = {
    if(this.corduraActual <= horror) {
      this.estaLoco = true
      this.corduraActual = 0
    } else {
      this.corduraActual -= horror
    }
  }

  def recuperarCordura(cordura: Int) = {
    if(this.corduraActual + cordura <= this.corduraInicial) {
      this.corduraActual += cordura
    } else {
      this.corduraActual = this.corduraInicial
    }
  }

}
