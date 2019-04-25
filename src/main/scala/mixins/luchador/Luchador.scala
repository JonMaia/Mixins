package mixins.luchador

import mixins.Personaje

trait Luchador extends Personaje {

  def atacar(): Unit = {
    this.oponente().recibirDanio(this.danio())
  }


  def danio(): Double


  def oponente(): Personaje

}
