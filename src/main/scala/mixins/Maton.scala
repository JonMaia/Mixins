package mixins

import clases.Investigador

/** Si luego de un ataque consigue matar al oponente, el matón ganará confianza y recuperará toda su cordura */
trait Maton extends Investigador{

  override def atacar(): Unit = {
    var oponente = habitacion.monstruoMasPoderoso()

    super.atacar()
    this.ganarConfianza(oponente)

  }

  /** Recupera la cordura inicial si el opoenente esta muerto */
  def ganarConfianza(oponente :Personaje): Unit = {
    if(oponente.estaMuerto()) {
      this.recuperarCordura(this.corduraInicial)
    }
  }

}
