import clases.{Habitacion, Investigador, Monstruo}
import org.scalatest.{FunSpec, Matchers}

class InvestigadorSpec extends FunSpec with Matchers {
  describe("clases.Investigador.atacar(monstruo)") {
    it("Un investigador ataca a un monstruo y le ocaciona danio") {
      val investigador = new Investigador(10)
      val monstruo = new Monstruo(20)
      val habitacion = new Habitacion

      habitacion.agregarHabitante(investigador)
      habitacion.agregarHabitante(monstruo)

      investigador.atacar()

      monstruo.vida < 20 shouldBe true
    }

    it("Un investigador ataca en una habitación con un monstruo y otro investigador y ocaciona danio al monstruo") {
      val investigador1 = new Investigador(10)
      val investigador2 = new Investigador(10)
      val monstruo = new Monstruo(20)
      val habitacion = new Habitacion

      habitacion.agregarHabitante(investigador1)
      habitacion.agregarHabitante(investigador2)
      habitacion.agregarHabitante(monstruo)

      investigador1.atacar()

      investigador1.vida shouldEqual 10
      investigador2.vida shouldEqual 10
      monstruo.vida < 20 shouldBe true
    }

    it("Un investigador es atacado, se muere y es retirado de la habitación"){
      val investigador = new Investigador(1)
      val monstruo = new Monstruo(20)
      val habitacion = new Habitacion

      habitacion.agregarHabitante(investigador)
      habitacion.agregarHabitante(monstruo)

      habitacion.personajes.size shouldEqual 2
      habitacion.investigadores().size shouldEqual 1

      monstruo.atacar()

      habitacion.personajes.size shouldEqual 1
      habitacion.investigadores().size shouldEqual 0
    }

  }

}
