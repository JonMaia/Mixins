import `object`.MansionesUtils
import clases.{Arma, Habitacion, Investigador}
import mixins.Humanoide
import mixins.arma.maldiciones.ArmaMalditaQueInfligeDanioPropio
import mixins.arma.{ArmaEsfuerzoFisico, ConArma}
import org.scalatest.{FunSpec, Matchers}

class HumanoideSpec extends FunSpec with Matchers {

  describe("clases.Humanoide.ocacionarHorror(investigador)") {

    it("Un humanoide horroriza a un investigador con 10 pts de cordura") {

      val humanoide = new Humanoide(20,10)
      val investigador = new Investigador(10, 10)

      humanoide.ocacionarHorror(investigador)

      investigador.getCorduraActual() shouldBe 9
    }
  }


  
  describe("clases.Humanoide.atacar(investigador)") {

    it("Un monstruo desarmado ataca a un investigador y lo dania en 1 punto") {
      MansionesUtils.activar()
      val humanoide = new Humanoide(20, 10)
      val investigador = new Investigador(30, 20)
      val habitacion = new Habitacion

      habitacion.agregarHabitante(humanoide)
      habitacion.agregarHabitante(investigador)

      humanoide.atacar()

      investigador.vida shouldEqual 10
    }

    it("Un monstruo con un bate ataca a un investigador y lo dania en 1 punto") {

      val bate = new Arma with ArmaEsfuerzoFisico with ArmaMalditaQueInfligeDanioPropio
      val humanoide = new Humanoide(3, 5) with ConArma
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
