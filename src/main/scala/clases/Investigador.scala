package clases

import mixins.{Luchador, Personaje}
import scala.util.Random

class Investigador(val vidaInicial: Int, val corduraInicial: Int) extends Personaje with Luchador {

  var estaLoco: Boolean = false
  override var vida: Int = vidaInicial
  var corduraActual: Int = corduraInicial

  override def danio(): Int = {
    Random.nextInt(vida - 1) + 1
  }

  override def atacar(): Unit = {
    habitacion.monstruoMasPoderoso().recibirDanio(danio())
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

  def recuperarTodaLaCordura(): Unit = {
    this.corduraActual = 100
  }

  def recuperarCordura(cordura: Int) = {
    if(this.corduraActual + cordura <= this.corduraInicial) {
      this.corduraActual += cordura
    } else {
      this.corduraActual = this.corduraInicial
    }
  }

  override def entrarEnHabitacion(habitacion: Habitacion): Unit = {
    super.entrarEnHabitacion(habitacion)
    habitacion.monstruos().foreach(monstruo => monstruo.ocacionarHorror(this))
  }

}

