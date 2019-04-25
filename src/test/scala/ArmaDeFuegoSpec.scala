import clases.{Arma, Habitacion, Investigador, Monstruo}
import mixins.arma.{ArmaDeFuego,ConArma}
import org.scalatest.{FunSpec, Matchers}

class ArmaDeFuegoSpec extends FunSpec with Matchers {
  describe("investigador.atacar() con ArmaDeFuego") {
    it("Investigador con 20 pts de vida ataca a un mounstruo con un arma de fuego ocacionando 10 pts de danio") {
      val armaDeFuego = new Arma with ArmaDeFuego
      armaDeFuego.danioArmaDeFuego=10.0
      val investigador = new Investigador(20, 10) with ConArma
      val monstruo = new Monstruo(20)
      val habitacion = new Habitacion()

      investigador.equiparArma(armaDeFuego)
      investigador.entrarEnHabitacion(habitacion)
      monstruo.entrarEnHabitacion(habitacion)

      investigador.atacar()

      monstruo.vida shouldEqual 10 // El investigador le ocaciona 30 de danio al monstruo

    }
  }

}
