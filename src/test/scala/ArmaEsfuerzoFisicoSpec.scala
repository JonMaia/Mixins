import clases.{Arma, Habitacion, Investigador, Monstruo}
import mixins.arma.{ArmaEsfuerzoFisico, ConArma}
import org.scalatest.{FunSpec, Matchers}

class ArmaEsfuerzoFisicoSpec extends FunSpec with Matchers {
  describe("investigador.portarArma(ConArmaDeEsfuerzoFisico)") {
    it("Un investigador porta un bate como arma") {
      val bate = new Arma with ArmaEsfuerzoFisico
      val investigador = new Investigador(20, 10) with ConArma
      val monstruo = new Monstruo(31)
      val habitacion = new Habitacion()

      investigador.equiparArma(bate)
      investigador.entrarEnHabitacion(habitacion)
      monstruo.entrarEnHabitacion(habitacion)

      investigador.atacar()

      monstruo.vida shouldEqual 1

    }
  }

}
