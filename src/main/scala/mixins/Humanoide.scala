package mixins

import clases.{Investigador,Monstruo}


trait Humanoide extends Monstruo{

  var cordura: Int = _

  override def danio(): Double = {

    super.danio()
  }


  override def recibirDanio(danio: Double): Unit = {
    this.cordura  -= 1
    super.recibirDanio(danio)
  }




}
