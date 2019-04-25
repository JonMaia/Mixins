import `object`.MansionesUtils
import clases.Investigador
import org.scalatest.{FunSpec, Matchers}

class MansionesUtilsSpec extends FunSpec with Matchers {

  describe("MansionesUtils.randomElement(lista)") {
    it("Cuando MansionUtils Esta activo siempre elijo al primer personaje de la lista") {
      val investigador1 = new Investigador(10, 10)
      val investigador2 = new Investigador(10, 10)
      val investigador3 = new Investigador(10, 10)
      val investigador4 = new Investigador(10, 10)
      val investigador5 = new Investigador(10, 10)
      val listaDePersonajes = List(investigador1, investigador2, investigador3, investigador4, investigador5)

      MansionesUtils.activar()
      MansionesUtils.randomElement(listaDePersonajes) shouldEqual investigador1

    }

  }

  describe("MansionesUtils.randomIntBetween(low, high)") {

    it("si esta activo el MansionUtils retorna el numero @param high") {

      var numeroElegido = MansionesUtils.randomIntBetween(0,5)

      numeroElegido shouldEqual 5
    }

  }
}
