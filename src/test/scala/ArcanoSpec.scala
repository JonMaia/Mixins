import `object`.MansionesUtils
import clases.{Habitacion, Investigador, Monstruo}
import mixins.luchador.Arcano
import org.scalatest.{FunSpec, Matchers}

class ArcanoSpec extends FunSpec with Matchers {
  describe("Arcano.atacar") {
    it("Un arcano ataca a un investigador y lo ocaciona 25 de danio, que igual a la cantidad de cordura perdida de" +
      "todos los investigadores. Tambien los volvio loco ") {
      MansionesUtils.activar()

      val investigador1 = new Investigador(30, 15)
      val investigador2 = new Investigador(20, 10)
      val zombie = new Monstruo(40) with Arcano
      val habitacion = new Habitacion

      investigador1.entrarEnHabitacion(habitacion)
      investigador2.entrarEnHabitacion(habitacion)
      zombie.entrarEnHabitacion(habitacion)

      zombie.atacar()
      investigador1.vida shouldEqual 5
      investigador2.vida shouldEqual 20


    }

  }

}
