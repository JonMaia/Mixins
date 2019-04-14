package clases

import `object`.MansionesUtils
import mixins.sanador.Sanador
import mixins.Personaje
import mixins.luchador.Luchador

import scala.util.Random

class Investigador(val vidaInicial: Int, val corduraInicial: Int) extends Personaje with Luchador with Sanador {

  var vida: Int = vidaInicial
  var corduraActual: Int = corduraInicial

  override def curar(personaje: Personaje): Unit = {
    personaje.recibirCuracion(this.puntosACurar())
  }

  override def puntosACurar(): Int = 0

  override def danio(): Int = {
    Random.nextInt(vida - 1) + 1
  }

  def estaLoco(): Boolean = {
    this.corduraActual == 0
  }

  def getCorduraActual(): Int = {
    this.corduraActual
  }

  def recibirHorror(horror: Int): Unit = {

    if(this.corduraActual <= horror) {
      this.corduraActual = 0
    } else {
      this.corduraActual -= horror
    }
  }

  //
  def recuperarTodaLaCordura(): Unit = {
    this.corduraActual = this.corduraInicial
  }

  def recuperarCordura(cordura: Int): Unit = {

    if(this.corduraActual + cordura <= this.corduraInicial) {
      this.corduraActual += cordura
    } else {
      this.corduraActual = this.corduraInicial
    }
  }

  //Propósito: Cuando un Investigador entra en la habitación recibe horrores de todos los monstruos que hay en ella.
  override def entrarEnHabitacion(habitacion: Habitacion): Unit = {
    super.entrarEnHabitacion(habitacion)
    habitacion.monstruos().foreach(monstruo => monstruo.ocacionarHorror(this))
  }

  //Propósito: Selecciona un Monstruo como oponente para atacar. Si esta loco seleccionará, como oponente para atacar,
  // a cualquiera que se encuentre en la misma habitación.
  override def oponente(): Personaje = {
    if (!this.estaLoco()) {
      this.habitacion.monstruoMasPoderoso()
    } else {
      MansionesUtils.randomElement(this.habitacion.personajes)
    }
  }

}

