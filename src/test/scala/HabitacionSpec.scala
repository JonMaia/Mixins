import clases.{Habitacion, Investigador, Monstruo}
import mixins.luchador.Bestia
import org.scalatest.{FunSpec, Matchers}

class HabitacionSpec extends FunSpec with Matchers {

  describe("clases.Habitacion.agregarPersonaje(personaje)") {

    it("Agrego dos personajes en la habitación y personajes tiene size 2") {
      val investigador = new Investigador(10, 20)
      val monstruo = new Monstruo(20)
      val habitacion = new Habitacion

      habitacion.agregarHabitante(investigador)
      habitacion.agregarHabitante(monstruo)

      habitacion.personajes.size shouldEqual 2
    }

  }

  describe("clases.Habitacion.monstruos()") {

    it("Agrego dos monstruos en la habitación y un investigador y le pregunto por el size de monstruos y denota 2") {
      val investigador = new Investigador(10, 20)
      val monstruo1 = new Monstruo(20)
      val monstruo2 = new Monstruo(23)
      val habitacion = new Habitacion
      val listaDeMonstruos = List(monstruo1, monstruo2)

      habitacion.agregarHabitante(investigador)
      habitacion.agregarHabitante(monstruo1)
      habitacion.agregarHabitante(monstruo2)

      habitacion.monstruos().size shouldEqual 2
      habitacion.monstruos() shouldEqual listaDeMonstruos
    }

    it("Agrego dos investigadores en la habitación y un monstruo y le pregunto por el size de investigadores y " +
      "denota 2") {
      val investigador1 = new Investigador(10, 20)
      val investigador2 = new Investigador(11, 20)
      val monstruo = new Monstruo(23)
      val habitacion = new Habitacion
      val listaDeInvestigadores = List(investigador1, investigador2)

      habitacion.agregarHabitante(investigador1)
      habitacion.agregarHabitante(investigador2)
      habitacion.agregarHabitante(monstruo)

      habitacion.investigadores().size shouldEqual 2
      habitacion.investigadores() shouldEqual listaDeInvestigadores
    }

    it("Agrego un investigador y dos monstruos (monstruo1 con 20 de vida y mostruo2 con 30 de vida) en la habitación " +
      "y pregunto por el monstruo más poderoso y retorna monstruo 2") {
      val investigador = new Investigador(10, 20)
      val monstruo1 = new Monstruo(20)
      val monstruo2 = new Monstruo(30)
      val habitacion = new Habitacion

      habitacion.agregarHabitante(investigador)
      habitacion.agregarHabitante(monstruo1)
      habitacion.agregarHabitante(monstruo2)

      habitacion.monstruoMasPoderoso() shouldEqual monstruo2
    }
  }

  describe("clases.habitacion.investigadores()") {

    it("Hay 2 investigadores en la habitacion y entra un monstruo que ocaciona 1 de horror a ambos, entonces se reduce" +
      "su cordura en 1 punto a cada uno") {
      val investigador = new Investigador(10, 20)
      val investigador2 = new Investigador(10, 20)
      val monstruo1 = new Monstruo(23)
      val habitacion = new Habitacion

      habitacion.agregarHabitante(investigador)
      habitacion.agregarHabitante(investigador2)
      habitacion.agregarHabitante(monstruo1)

      habitacion.investigadores().map(investigador => investigador.recibirHorror(monstruo1.horror()))

      investigador.getCorduraActual() equals(19)
      investigador2.getCorduraActual() equals(19)

    }
  }

  describe("clases.habitacion.investigadores().recibirDanio()") {

    it("Hay 2 investigadores y un monstruo-bestia en una habitacion, cuando el monstruo ataca escoge al mas debil de los" +
      "2 investigadores y le inflige 1 de daño ya que se encuentra solo") {
      val investigador = new Investigador(4, 20)
      val investigador2 = new Investigador(10, 20)
      val bestia = new Monstruo(23) with Bestia
      val habitacion = new Habitacion

      habitacion.agregarHabitante(investigador)
      habitacion.agregarHabitante(investigador2)
      habitacion.agregarHabitante(bestia)

      bestia.atacar()

      investigador.vida equals(3)
    }
  }
}
