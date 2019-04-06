trait Luchador {

  def atacar(personaje :Personaje): Unit = {
    personaje.recibirDanio(this.danio())
  }

  def danio() :Int

}
