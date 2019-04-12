import clases.{Habitacion,InvestigadorBarserker, Monstruo}
import org.scalatest.{FunSpec, Matchers}

class InvestigadorBarserkerSpec extends FunSpec with Matchers {
  describe("clases.InvestigadorBarserker.atacar(monstruo)") {
    it("Un investigador cuerdo ataca a un monstruo y le ocaciona danio") {
      val investigador = new InvestigadorBarserker(2, 20)
      val monstruo = new Monstruo(20)
      val habitacion = new Habitacion

      habitacion.agregarHabitante(investigador)
      habitacion.agregarHabitante(monstruo)

      investigador.atacar()

      monstruo.vida == 19 shouldBe true
    }

    it("Un investigador loco ataca a un monstruo y le ocaciona el doble danio") {
      val investigador = new InvestigadorBarserker(2, 20)
      val monstruo = new Monstruo(20)
      val habitacion = new Habitacion

      habitacion.agregarHabitante(investigador)
      habitacion.agregarHabitante(monstruo)

      investigador.recibirHorror(20)
      investigador.getEstaLoco() shouldBe true

      investigador.atacar()

      monstruo.vida == 18 shouldBe true
    }

  }
}
