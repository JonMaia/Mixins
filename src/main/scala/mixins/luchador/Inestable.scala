package mixins.luchador

import clases.Investigador

/** Cada vez que su cordura baja, se causa un punto de daño a si mismo */
trait Inestable extends Investigador {

  override def recibirHorror(horror: Int): Unit = {
    this.recibirDanio(1)
    super.recibirHorror(horror)
  }

}
