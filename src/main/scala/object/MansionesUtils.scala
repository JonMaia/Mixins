package `object`

import scala.util.Random

object MansionesUtils {
  var state: Boolean = false
  var low: Int = _
  var high: Int = _

  /** Retorna un entero aleatorio entre el rango dado [low - high] */
  def randomIntBetween(low: Int, high: Int): Int = new Random().nextInt(high - low) + low

  /** Redondea un número decimal a entero */
  def roundInt(d: Double): Int = Math.round(d).asInstanceOf[Int]

  /** Retorna un elemento aleatorio de la lista data */
  def randomElement[T](lista: List[T]) : T = lista(randomIntBetween(0, lista.length))

  def danioControlable(): Int = randomIntBetween(low, high)

}