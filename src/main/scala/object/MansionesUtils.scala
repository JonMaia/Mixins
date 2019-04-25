package `object`

import scala.util.Random

object MansionesUtils {
  var state: Boolean = false

  /** Retorna un entero aleatorio entre el rango dado [low - high] si es que el state es false, de lo contrario
    * retorna el parametro high*/
  def randomIntBetween(low: Int, high: Int): Int = {
    if(!this.state) {
      new Random().nextInt(high - low) + low
    } else {
      high
    }
  }

  /** Redondea un número decimal a entero */
  def roundInt(d: Double): Int = Math.round(d).asInstanceOf[Int]

  /** Retorna un elemento aleatorio de la lista data */
  def randomElement[T](lista: List[T]): T = {
    if (!this.state) {
      lista(randomIntBetween(0, lista.length))
    } else {
      lista.head
    }

  }

  def activar(): Unit = {
    this.state = true
  }

  def desactivar(): Unit = {
    this.state = false
  }

}
