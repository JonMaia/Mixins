import clases.{Habitacion, Investigador, Monstruo}
import org.scalatest.{FunSpec, Matchers}

class MatonSpec extends FunSpec with Matchers {
  describe("Maton.atacar") {
    it("un Investigador Maton entra en una habitacion que tiene un monstruo y pierde cordura, ataca a un monstruo sin lograr matarlo, " +
      "entonces no recupera toda su cordura") {

      val maton = new Investigador(10, 10)
      val monstruo = new Monstruo(20)
      val habitacion = new Habitacion()

      monstruo.entrarEnHabitacion(habitacion)
      maton.entrarEnHabitacion(habitacion)

      monstruo.estaMuerto() shouldBe false
      maton.corduraActual shouldEqual 9
      maton.corduraInicial shouldEqual 10

      maton.atacar()

      monstruo.estaMuerto() shouldBe false
      maton.corduraActual shouldEqual 9
      maton.corduraInicial shouldEqual 10

    }

    it("un Investigador Maton entra en una habitacion que tiene un monstruo y pierde cordura, ataca a un monstruo" +
      " y logra matarlo, entonces recupera toda su cordura") {

      val maton = new Investigador(10, 10)
      val monstruo = new Monstruo(1)
      val habitacion = new Habitacion()

      monstruo.entrarEnHabitacion(habitacion)
      maton.entrarEnHabitacion(habitacion)

      monstruo.estaMuerto() shouldBe false
      maton.corduraActual shouldEqual 9
      maton.corduraInicial shouldEqual 10

      maton.atacar()

      monstruo.estaMuerto() shouldBe true
      maton.corduraActual shouldEqual 10
      maton.corduraInicial shouldEqual 10


    }
  }

}
