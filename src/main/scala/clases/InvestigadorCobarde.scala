package clases

import mixins.luchador.Cobarde


class InvestigadorCobarde(override val vidaInicial: Double,override val corduraInicial: Int)
  extends Investigador(vidaInicial,corduraInicial) with Cobarde{

}
