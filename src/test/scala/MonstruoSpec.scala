import org.scalatest.{FunSpec, Matchers}

class MonstruoSpec extends FunSpec with Matchers {
  describe("Monstruo.atacar(Investigador)") {
    it("Un monstruo ataca a un investigador y le ocaciona un danio de 1") {

      val monstruo = new Monstruo(20)
      val investigador = new Investigador(10)

      monstruo.atacar(investigador)

      investigador.vida shouldEqual 9
    }
  }

}
