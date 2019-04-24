import clases.{Habitacion, Investigador, Monstruo}
import mixins.arma.ArmaMalditaConDanioReducido
import org.scalatest.{FunSpec, Matchers}


class ArmaMalditaConDanioReducidoSpec extends FunSpec with Matchers {

  describe("Investigador haciendo danio con un arma maldita con reduccion de danio") {
    it("Un investigador de 3 de vida, ataca a un monstruo con 4 de vida, infligiendo 1 punto de danio ") {
      val investigador = new Investigador(3, 5) with ArmaMalditaConDanioReducido
      val monstruo = new Monstruo(4)
      val habitacion = new Habitacion

      habitacion.agregarHabitante(investigador)
      habitacion.agregarHabitante(monstruo)

      investigador.atacar()

      monstruo.vida shouldBe 3
    }

  }

}