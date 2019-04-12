package mixins.luchador

import clases.Investigador

trait Cobarde extends Investigador{
  override def atacar(): Unit = {
    this.habitacion.monstruoMasPoderoso().recibirDanio(this.danio())
    this.recibirHorror(1)
  }
}
