package clases

import mixins.Cobarde


class InvestigadorCobarde(override val vidaInicial: Int,override val corduraInicial: Int)
  extends Investigador(vidaInicial,corduraInicial) with Cobarde{

}
