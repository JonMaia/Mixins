import clases.{Habitacion, Investigador, Monstruo}
import org.scalatest.{FunSpec, Matchers}

class MonstruoSpec extends FunSpec with Matchers {

  describe("clases.Monstruo.ocacionarHorror(investigador)") {

    it("Un monstruo ocaciona horror a un investigador con 10 de cordura, entonces se le restara 1 quedando en 9") {

      val monstruo = new Monstruo(20)
      val investigador = new Investigador(10, 10)

      monstruo.ocacionarHorror(investigador)

      investigador.getCorduraActual() shouldBe 9
    }
  }

  describe("clases.Monstruo.atacar(investigador)") {

    it("Un monstruo ataca a un investigador y le ocaciona un danio de 1") {

      val monstruo = new Monstruo(20)
      val investigador = new Investigador(10, 20)
      val habitacion = new Habitacion

      habitacion.agregarHabitante(monstruo)
      habitacion.agregarHabitante(investigador)

      monstruo.atacar()

      investigador.vida shouldEqual 9
    }
  }

}
