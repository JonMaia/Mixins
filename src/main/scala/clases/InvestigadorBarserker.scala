package clases

import mixins.luchador.Barserker


class InvestigadorBarserker(override val vidaInicial: Int,override val corduraInicial: Int)
  extends Investigador(vidaInicial,corduraInicial) with Barserker{

}