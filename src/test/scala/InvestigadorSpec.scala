import clases.{Habitacion, Investigador, Monstruo}
import mixins.luchador.Luchador
import mixins.sanador.{Curandero, Martir}
import org.scalatest.{FunSpec, Matchers}

class InvestigadorSpec extends FunSpec with Matchers {

  describe("clases.Investigador.atacar(monstruo)") {

    it("Un investigador ataca a un monstruo y le ocaciona danio") {
      val investigador = new Investigador(10, 20)
      val monstruo = new Monstruo(20)
      val habitacion = new Habitacion

      habitacion.agregarHabitante(investigador)
      habitacion.agregarHabitante(monstruo)

      investigador.atacar()

      monstruo.vida < 20 shouldBe true
    }

    it("Un investigador ataca en una habitación con un monstruo y otro investigador y ocaciona danio al monstruo") {
      val investigador1 = new Investigador(10, 20)
      val investigador2 = new Investigador(10, 20)
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
      val investigador = new Investigador(1, 20)
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
  describe("Investigador.recibirHorror()") {

      it("Dado un Investigador que recibe horror y su corduraActual se reduce en 5 puntos, cuando le pregunto si esta" +
        "loco me dice que no") {

        val investigador = new Investigador(10,10)

        investigador.recibirHorror(5)

        investigador.getEstaLoco() shouldBe false
        investigador.getCorduraActual() shouldBe 5

      }

      it("Dado un Investigador con cordura inicial 10 y actual 5, recupera su cordura actual en 5 puntos, cuando le" +
        "pregunto su cordura actual me dice 10") {

        val investigador = new Investigador(10,10)

        investigador.recibirHorror(5)
        investigador.recuperarCordura(5)

        investigador.getEstaLoco() shouldBe false
        investigador.getCorduraActual() shouldBe 10

      }

      it("Dado un Investigador con cordura inicial 10 y actual 10, cuando le digo recuperarCordura no hace nada") {

        val investigador = new Investigador(10,10)

        investigador.recuperarCordura(10)

        investigador.getEstaLoco() shouldBe false
        investigador.getCorduraActual() shouldBe 10

      }
    }

    describe("clases.Investigador.Curandero.curar()") {
      it("Dado un Investigador-Curandero cura 2 puntos de vida a un Investigador dañado con 8 de vida, de 10") {

        val curandero = new Investigador(10, 20) with Curandero
        val investigador = new Investigador(10, 20)

        investigador.recibirDanio(2)
        curandero.curar(investigador)

        investigador.vida shouldBe 10

      }
    }

    describe("clases.Investigador.Martir.curar()") {
      it("Dado un Investigador-Martir cura 4 puntos de cordura a un Investigador loco, entonces el Investigador-Martir"+
      "perdería 2 puntos de salud") {

        val martir = new Investigador(10, 20) with Martir
        val investigador = new Investigador(10, 10) with Luchador

        investigador.recibirHorror(10)
        martir.curar(investigador)

        investigador.getCorduraActual() shouldBe 4
        martir.vida shouldBe 8
      }
  }
}
