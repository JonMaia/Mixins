import `object`.MansionesUtils
import clases.Investigador
import org.scalatest.{FunSpec, Matchers}

class MansionesUtilsSpec extends FunSpec with Matchers {

  describe("MansionesUtils.randomElement(lista)") {
    it("Elijo a un personaje de forma azarosa") {
      val investigador1 = new Investigador(10, 10)
      val listaDePersonajes = List(investigador1)

      MansionesUtils.randomElement(listaDePersonajes) shouldEqual investigador1

    }

  }
}
