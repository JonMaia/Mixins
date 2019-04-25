import clases.{Arma, Habitacion, Investigador, Monstruo}
import mixins.arma.ConArma
import mixins.arma.Desgastes.ArmaDesgastable
import org.scalatest.{FunSpec, Matchers}

class ArmaDesgastableSpec extends FunSpec with Matchers {
  describe("Investigador.atacar() con ArmaDesgastable") {
    it("Un Investigador ataca varias veces a un monstruo con un bate desgastable." +
      "despues del tercer ataque, no ocasiona mas danio") {

      val bate = new Arma with ArmaDesgastable
      val investigador = new Investigador(2, 10) with ConArma
      val monstruo = new Monstruo(30)
      val habitacion = new Habitacion

      bate.setUsos(3)
      bate.setDanio(3)
      investigador.equiparArma(bate)

      investigador.entrarEnHabitacion(habitacion)
      monstruo.entrarEnHabitacion(habitacion)

      investigador.atacar()
      monstruo.vida shouldEqual 27

      investigador.atacar()
      monstruo.vida shouldEqual 24

      investigador.atacar()
      monstruo.vida shouldEqual 21

      investigador.atacar()
      monstruo.vida shouldEqual 21
    }
  }
}
