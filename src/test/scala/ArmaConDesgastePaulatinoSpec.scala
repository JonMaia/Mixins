import clases.{Arma, Habitacion, Investigador, Monstruo}
import mixins.arma.ConArma
import mixins.arma.Desgastes.ArmaConDesgastePaulatino
import org.scalatest.{FunSpec, Matchers}

class ArmaConDesgastePaulatinoSpec extends FunSpec with Matchers {
  describe("investigador.atacar() con ArmaConDesgastePaulatino") {
    it("Un investigador ataca a un monstruo con un hacha con desgaste pulatino, su danio va disminuyendo" +
      "hasta el quinto ataque, luego es constante") {

      val hacha = new Arma with ArmaConDesgastePaulatino
      val investigador = new Investigador(10, 20) with ConArma
      val monstruo = new Monstruo(100)
      val habitacion = new Habitacion

      hacha.setDanio(10)
      investigador.equiparArma(hacha)

      investigador.entrarEnHabitacion(habitacion)
      monstruo.entrarEnHabitacion(habitacion)

      investigador.atacar()
      monstruo.vida shouldEqual 90  // Ocasiona 10 de danio

      investigador.atacar()
      monstruo.vida shouldEqual 81  // Ocasiona 9 de danio

      investigador.atacar()
      monstruo.vida shouldEqual 73  // Ocasiona 8 de danio

      investigador.atacar()
      monstruo.vida shouldEqual 66  // Ocasiona 7 de danio

      investigador.atacar()
      monstruo.vida shouldEqual 60  // Ocasiona 6 de danio

      investigador.atacar()
      monstruo.vida shouldEqual 55  // Ocasiona 5 de danio

      investigador.atacar()
      monstruo.vida shouldEqual 50  // Ocasiona 5 de danio

      investigador.atacar()
      monstruo.vida shouldEqual 45  // Ocaciona 5 de danio

    }

  }
}
