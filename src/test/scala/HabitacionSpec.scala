import clases.{Habitacion, Investigador, Monstruo}
import org.scalatest.{FunSpec, Matchers}

class HabitacionSpec extends FunSpec with Matchers {
  describe("clases.Habitacion.agregarPersonaje(personaje)") {
    it("Agrego dos personajes en la habitación y personajes tiene size 2") {
      val investigador = new Investigador(10)
      val monstruo = new Monstruo(20)
      val habitacion = new Habitacion

      habitacion.agregarHabitante(investigador)
      habitacion.agregarHabitante(monstruo)

      habitacion.personajes.size shouldEqual 2
    }

  }

  describe("clases.Habitacion.monstruos()")

    it("Agrego dos monstruos en la habitación y un investigador y le pregunto por el size de monstruos y denota 2") {
      val investigador = new Investigador(10)
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
      val investigador1 = new Investigador(10)
      val investigador2 = new Investigador(11)
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
      val investigador = new Investigador(10)
      val monstruo1 = new Monstruo(20)
      val monstruo2 = new Monstruo(30)
      val habitacion = new Habitacion

      habitacion.agregarHabitante(investigador)
      habitacion.agregarHabitante(monstruo1)
      habitacion.agregarHabitante(monstruo2)

      habitacion.monstruoMasPoderoso() shouldEqual monstruo2
    }
  }
}
