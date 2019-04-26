import clases.{Arma, Habitacion, Investigador, Monstruo}
import org.scalatest.{FunSpec, Matchers}
import mixins.Humanoide
import mixins.arma.{ArmaEsfuerzoFisico, ConArma}
import mixins.arma.maldiciones.ArmaMalditaQueInfligeDanioPropio

class HumanoideSpec extends FunSpec with Matchers {

  describe("clases.Humanoide.ocacionarHorror(investigador)") {

    it("Un humanoide horroriza a un investigador con 10 pts de cordura") {

      val humanoide = new Monstruo(20) with Humanoide
      val investigador = new Investigador(10, 10)

      humanoide.ocacionarHorror(investigador)

      investigador.getCorduraActual() shouldBe 9
    }
  }


  
  describe("clases.Humanoide.atacar(investigador)") {

    it("Un monstruo desarmado ataca a un investigador y lo dania en 1 punto") {

      val humanoide = new Monstruo(20) with Humanoide
      val investigador = new Investigador(10, 20)
      val habitacion = new Habitacion

      habitacion.agregarHabitante(humanoide)
      habitacion.agregarHabitante(investigador)

      humanoide.atacar()

      investigador.vida shouldEqual 9
    }

    it("Un monstruo con un bate ataca a un investigador y lo dania en 1 punto") {

      val bate = new Arma with ArmaEsfuerzoFisico with ArmaMalditaQueInfligeDanioPropio
      val humanoide = new Monstruo(3) with Humanoide with ConArma
      humanoide.cordura = 5
      val investigador = new Investigador(5, 20)
      val habitacion = new Habitacion

      humanoide.equiparArma(bate)

      habitacion.agregarHabitante(humanoide)
      habitacion.agregarHabitante(investigador)

      humanoide.atacar()

      investigador.vida shouldEqual 2
      humanoide.vida shouldEqual 2

    }

  }
  
}
