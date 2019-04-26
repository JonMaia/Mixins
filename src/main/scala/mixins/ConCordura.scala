package mixins

trait ConCordura {

  val corduraInicial: Int
  var corduraActual: Int

  def getCorduraActual(): Int = {
    this.corduraActual
  }

  def recuperarCordura(cordura: Int): Unit = {

    if(this.corduraActual + cordura <= this.corduraInicial) {
      this.corduraActual += cordura
    } else {
      this.corduraActual = this.corduraInicial
    }
  }


  def recuperarTodaLaCordura(): Unit = {
    this.corduraActual = this.corduraInicial
  }

  def estaLoco(): Boolean = {
    this.corduraActual == 0
  }

  def volverLoco(): Unit ={
    this.corduraActual = 0
  }


}
