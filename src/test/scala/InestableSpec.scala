import clases.{Habitacion, Investigador, Monstruo}
import mixins.Inestable
import org.scalatest.{FunSpec, Matchers}

class InestableSpec extends FunSpec with Matchers {

  describe("Inestable.ocacionarHorror()") {

    it("Un investigador inestable recibe horror de un monstruo y también le ocasiona daño por 1") {
      val inestable = new Investigador(10, 10) with Inestable
      val monstruo = new Monstruo(20)
      val habitacion = new Habitacion()

      inestable.entrarEnHabitacion(habitacion)

      inestable.vida shouldEqual 10

      monstruo.entrarEnHabitacion(habitacion)

      inestable.vida shouldEqual 9
    }

  }


}
