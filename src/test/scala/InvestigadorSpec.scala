import `object`.MansionesUtils
import clases.{Habitacion, Investigador, Monstruo}
import mixins.luchador.{Barserker, Cobarde, Luchador}
import mixins.sanador.{Curandero, Martir}
import org.scalatest.{FunSpec, Matchers}

class InvestigadorSpec extends FunSpec with Matchers {

  describe("clases.Investigador.atacar()") {

    it("Un investigador ataca a un monstruo y le ocasiona daño") {
      val investigador = new Investigador(10, 20)
      val monstruo = new Monstruo(20)
      val habitacion = new Habitacion

      investigador.entrarEnHabitacion(habitacion)
      monstruo.entrarEnHabitacion(habitacion)
      investigador.atacar()

      monstruo.vida < 20 shouldBe true
    }

    it("Un investigador ataca en una habitación con un monstruo y otro investigador y sólo ocasiona daño al monstruo") {
      val investigador1 = new Investigador(10, 20)
      val investigador2 = new Investigador(10, 20)
      val monstruo = new Monstruo(20)
      val habitacion = new Habitacion

      investigador1.entrarEnHabitacion(habitacion)
      investigador2.entrarEnHabitacion(habitacion)
      monstruo.entrarEnHabitacion(habitacion)

      monstruo.vida shouldEqual 20

      investigador1.atacar()

      investigador1.vida shouldEqual 10
      investigador2.vida shouldEqual 10
      monstruo.vida < 20 shouldBe true
    }

    it("Un investigador es atacado, se muere y es retirado de la habitación"){
      val investigador = new Investigador(1, 20)
      val monstruo = new Monstruo(20)
      val habitacion = new Habitacion

      investigador.entrarEnHabitacion(habitacion)
      monstruo.entrarEnHabitacion(habitacion)

      habitacion.personajes.size shouldEqual 2
      habitacion.investigadores().size shouldEqual 1

      monstruo.atacar()

      habitacion.personajes.size shouldEqual 1
      habitacion.investigadores().size shouldEqual 0
    }

  }

  it("Cuando un investigador esta loco atacará, de forma azarosa, a cualquiera que se encuentre en la misma habitación") {

    val investigadorLoco = new Investigador(10,0)
    val investigador = new Investigador(12, 10)
    val monstruo = new Monstruo(20)
    val habitacion = new Habitacion
    MansionesUtils.activar()

    investigadorLoco.entrarEnHabitacion(habitacion)
    investigador.entrarEnHabitacion(habitacion)
    monstruo.entrarEnHabitacion(habitacion)

    investigadorLoco.atacar()

    investigadorLoco.vida < 10 shouldBe true
  }

  describe("Investigador.recibirHorror()") {

      it("Dado un Investigador que recibe horror y su corduraActual se reduce en 5 puntos, cuando le pregunto si esta" +
        "loco me dice que no") {

        val investigador = new Investigador(10,10)

        investigador.recibirHorror(5)

        investigador.estaLoco() shouldBe false
        investigador.getCorduraActual() shouldBe 5

      }

      it("Dado un Investigador con cordura inicial 10 y actual 5, recupera su cordura actual en 5 puntos, cuando le" +
        "pregunto su cordura actual me dice 10") {

        val investigador = new Investigador(10,10)

        investigador.recibirHorror(5)
        investigador.recuperarCordura(5)

        investigador.estaLoco() shouldBe false
        investigador.getCorduraActual() shouldBe 10

      }

      it("Dado un Investigador con cordura inicial 10 y actual 10, cuando le digo recuperarCordura no hace nada") {

        val investigador = new Investigador(10,10)

        investigador.recuperarCordura(10)

        investigador.estaLoco() shouldBe false
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

  describe("clases.InvestigadorBarserker.atacar(monstruo)") {
    MansionesUtils.activar()
    it("Un investigador cuerdo ataca a un monstruo y le ocaciona danio") {
      val investigador = new Investigador(2, 20) with Barserker
      val monstruo = new Monstruo(20)
      val habitacion = new Habitacion

      habitacion.agregarHabitante(investigador)
      habitacion.agregarHabitante(monstruo)

      investigador.atacar()

      monstruo.vida == 18 shouldBe true
    }

    it("Un investigador loco ataca a un monstruo y le ocaciona el doble danio") {
      val investigador = new Investigador(2, 20) with Barserker
      val monstruo = new Monstruo(20)
      val habitacion = new Habitacion

      habitacion.agregarHabitante(investigador)
      habitacion.agregarHabitante(monstruo)

      investigador.recibirHorror(20)
      investigador.estaLoco() shouldBe true

      investigador.atacar()

      monstruo.vida == 16 shouldBe true
    }

  }


  describe("clases.InvestigadorCobarde.atacar(monstruo)") {
    it("Un investigador ataca a un monstruo, le ocaciona danio y se auto dania") {
      val corduraInicial = 20
      val investigador = new Investigador(2, corduraInicial) with Cobarde
      val monstruo = new Monstruo(20)
      val habitacion = new Habitacion

      habitacion.agregarHabitante(investigador)
      habitacion.agregarHabitante(monstruo)

      investigador.atacar()

      monstruo.vida == 18 shouldBe true
      investigador.getCorduraActual() shouldBe corduraInicial-1
    }
  }

}
