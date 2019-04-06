class Monstruo(vidaInicial :Int) extends Personaje with Luchador {
  override var vida: Int = vidaInicial

  override def danio(): Int = 1
}
