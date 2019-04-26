package mixins

import `object`.MansionesUtils
import clases.Investigador


class Humanoide(vida: Int, cordura: Int) extends Investigador(vida, cordura) with ConHorror {


  override def oponente(): Personaje = {
    if (!this.estaLoco()) {
      this.habitacion.investigadorMasPoderoso()
    } else {
      MansionesUtils.randomElement(this.habitacion.personajes)
    }
  }


  override def recibirDanio(danio: Double): Unit = {
    this.recibirHorror(1)
    super.recibirDanio(danio)
  }

  override def ocacionarHorror(investigador: Investigador): Unit =  investigador.recibirHorror(this.horror())

  override def horror(): Int = 1
}
