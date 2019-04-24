import clases.{Habitacion, Investigador, Monstruo}
import mixins.arma.ArmaMalditaQueInfligeDanioAOtros
import org.scalatest.{FunSpec, Matchers}


class ArmaMalditaQueInfligeDanioAOtrosSpec extends FunSpec with Matchers {

  describe("Investigador haciendo danio con un arma maldita que inflige danio a otros") {
    it("Un investigador de 3 de vida, ataca a un monstruo con 4 de vida, infligiendo 1 punto de danio al investigador" +
      "que se encuentra en la misma habitacion") {
      val investigador = new Investigador(3, 5) with ArmaMalditaQueInfligeDanioAOtros
      val investigadorDaniado = new Investigador(2, 6)
      val monstruo = new Monstruo(4)
      val habitacion = new Habitacion

      habitacion.agregarHabitante(investigador)
      habitacion.agregarHabitante(investigadorDaniado)
      habitacion.agregarHabitante(monstruo)

      investigador.atacar()

      monstruo.vida shouldBe 3
      investigadorDaniado.vida shouldBe 1.8
    }
  }
}