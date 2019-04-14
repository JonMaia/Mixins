package mixins.luchador

import clases.Investigador

trait Cobarde extends Investigador{
  override def atacar(): Unit = {
    super.atacar()
    this.recibirHorror(1)
  }
}
