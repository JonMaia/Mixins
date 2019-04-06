import scala.util.Random

class Investigador(vidaInicial :Int) extends Personaje with Luchador {
  override var vida: Int = vidaInicial

  override def danio(): Int = {
    Random.nextInt(this.vida - 1) + 1
  }
}
