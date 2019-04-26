import clases.{Arma, Habitacion, Investigador, Monstruo}
import mixins.arma.maldiciones.ArmaMalditaQueInfligeDanioPropio
import mixins.arma.{ArmaEsfuerzoFisico, ConArma}
import org.scalatest.{FunSpec, Matchers}


class ArmaMalditaQueInfligeDanioPropioSpec extends FunSpec with Matchers {

  describe("Investigador haciendo danio con un arma maldita que inflige danio propio") {
    it("Un investigador de 3 de vida, ataca a un monstruo con 5 de vida, infligiendo 1 punto de danio al investigador ") {
      val bate = new Arma with ArmaEsfuerzoFisico with ArmaMalditaQueInfligeDanioPropio
      val investigador = new Investigador(3, 5) with ConArma
      val monstruo = new Monstruo(5)
      val habitacion = new Habitacion

      investigador.equiparArma(bate)
      habitacion.agregarHabitante(investigador)
      habitacion.agregarHabitante(monstruo)

      investigador.atacar()

      monstruo.vida shouldBe 2
      investigador.vida shouldBe 2
    }

  }

}