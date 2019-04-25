import clases.{Habitacion, Investigador, Monstruo}
import mixins.arma.ArmaMalditaQueInfligeDanioPropio
import org.scalatest.{FunSpec, Matchers}


class ArmaMalditaQueInfligeDanioPropioSpec extends FunSpec with Matchers {

  describe("Investigador haciendo danio con un arma maldita que inflige danio propio") {
    it("Un investigador de 3 de vida, ataca a un monstruo con 4 de vida, infligiendo 1 punto de danio al investigador ") {
      val investigador = new Investigador(3, 5) with ArmaMalditaQueInfligeDanioPropio
      val monstruo = new Monstruo(4)
      val habitacion = new Habitacion

      habitacion.agregarHabitante(investigador)
      habitacion.agregarHabitante(monstruo)

      investigador.atacar()

      monstruo.vida shouldBe 3
      investigador.vida shouldBe 2
    }

  }

}