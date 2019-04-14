package mixins.luchador

import mixins.Personaje

trait Luchador extends Personaje {

  def atacar(): Unit

  def danio(): Int

}
