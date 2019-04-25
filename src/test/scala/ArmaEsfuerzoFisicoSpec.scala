import clases.{Arma, Habitacion, Investigador, Monstruo}
import mixins.arma.{ArmaEsfuerzoFisico, ConArma}
import org.scalatest.{FunSpec, Matchers}

class ArmaEsfuerzoFisicoSpec extends FunSpec with Matchers {
  describe("investigador.atacar() con ArmaDeEsfuerzoFisico") {
    it("Un investigador con 20 de vida porta un bate como arma de esfuerzo fisico y ataca a un monstruo" +
      "y le ocaciona 30 de danio") {
      val bate = new Arma with ArmaEsfuerzoFisico
      val investigador = new Investigador(20, 10) with ConArma
      val monstruo = new Monstruo(31)
      val habitacion = new Habitacion()

      investigador.equiparArma(bate)
      investigador.entrarEnHabitacion(habitacion)
      monstruo.entrarEnHabitacion(habitacion)

      investigador.atacar()

      monstruo.vida shouldEqual 1 // El investigador le ocaciona 30 de danio al monstruo

    }
  }

}
