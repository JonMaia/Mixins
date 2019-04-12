import clases.{Habitacion, InvestigadorCobarde, Monstruo}
import org.scalatest.{FunSpec, Matchers}

class InvestigadorCobardeSpec extends FunSpec with Matchers {
  describe("clases.InvestigadorCobarde.atacar(monstruo)") {
    it("Un investigador ataca a un monstruo, le ocaciona danio y se auto dania") {
      val corduraInicial = 20
      val investigador = new InvestigadorCobarde(2, corduraInicial)
      val monstruo = new Monstruo(20)
      val habitacion = new Habitacion

      habitacion.agregarHabitante(investigador)
      habitacion.agregarHabitante(monstruo)

      investigador.atacar()

      monstruo.vida == 19 shouldBe true
      investigador.getCorduraActual() shouldBe corduraInicial-1
    }


  }
}
