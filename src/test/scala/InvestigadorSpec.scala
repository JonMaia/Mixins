import org.scalatest.{FunSpec, Matchers}

class InvestigadorSpec extends FunSpec with Matchers {
  describe("Un investigador ataca a un monstruo y le ocaciona danio") {
    val investigador = new Investigador(10)
    val monstruo = new Monstruo(20)

    investigador.atacar(monstruo)

    monstruo.vida < 20 shouldBe(true)

  }

}
