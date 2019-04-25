import clases.{Arma, Habitacion, Investigador, Monstruo}
import mixins.arma.{Hechizo, ConArma}
import org.scalatest.{FunSpec, Matchers}

class HechizoSpec extends FunSpec with Matchers {
  describe("investigador.atacar() con Hechizo") {
    it("Investigador con 30 pts de vida ataca a un mounstruo con 10 pts de vida con un hechizo ocacionando 10 pts de danio") {
      val hechizo = new Arma with Hechizo
      val investigador = new Investigador(20, 10) with ConArma
      val monstruo = new Monstruo(10)
      val habitacion = new Habitacion()


      hechizo.danioFijo = 30
      investigador.equiparArma(hechizo)
      investigador.entrarEnHabitacion(habitacion)
      monstruo.entrarEnHabitacion(habitacion)

      investigador.atacar()

      monstruo.vida shouldEqual 7 // El investigador le ocaciona 3 pts de danio al monstruo

    }

  }

}
