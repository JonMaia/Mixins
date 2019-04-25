import clases.{Arma, Habitacion, Investigador, Monstruo}
import mixins.arma.maldiciones.ArmaMalditaConDanioReducido
import mixins.arma.{ArmaEsfuerzoFisico, ConArma}
import org.scalatest.{FunSpec, Matchers}


class ArmaMalditaConDanioReducidoSpec extends FunSpec with Matchers {

  describe("Investigador haciendo danio con un arma maldita con reduccion de danio") {
    it("Un investigador de 3 de vida, ataca a un monstruo con 4 de vida, infligiendo 3.5 punto de danio ") {
      val bate = new Arma with ArmaEsfuerzoFisico with ArmaMalditaConDanioReducido
      val investigador = new Investigador(3, 5) with ConArma
      val monstruo = new Monstruo(4)
      val habitacion = new Habitacion

      investigador.equiparArma(bate)
      habitacion.agregarHabitante(investigador)
      habitacion.agregarHabitante(monstruo)

      investigador.atacar()

      monstruo.vida shouldBe 0.5
    }

  }

}