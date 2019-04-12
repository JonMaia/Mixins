package mixins
import clases.Investigador

trait Barserker  extends Investigador {
  override def atacar(): Unit = {
    var danioACausar = if (this.estaLoco) this.danio()*2 else this.danio()// Preguntar por que no anda
    this.habitacion.monstruoMasPoderoso().recibirDanio(danioACausar)
  }
}
