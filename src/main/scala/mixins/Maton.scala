package mixins

import clases.Investigador

trait Maton extends Investigador{
  override def atacar(): Unit = {
    var oponente = habitacion.monstruoMasPoderoso()

    super.atacar()
    this.ganarConfianza(oponente)

  }

  def ganarConfianza(oponente :Personaje): Unit = {
    if(oponente.estaMuerto()) {
      this.recuperarCordura(this.corduraInicial)
    }
  }

}
