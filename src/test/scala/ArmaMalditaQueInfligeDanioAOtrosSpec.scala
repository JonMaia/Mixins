
import `object`.MansionesUtils
import clases.{Arma, Habitacion, Investigador, Monstruo}
import mixins.arma.{ArmaEsfuerzoFisico, ConArma}
import mixins.arma.maldiciones.ArmaMalditaQueInfligeDanioAOtros
import org.scalatest.{FunSpec, Matchers}

class ArmaMalditaQueInfligeDanioAOtrosSpec extends FunSpec with Matchers {
  MansionesUtils.activar()
  describe("Investigador haciendo danio con un arma maldita que inflige danio a otros") {
    it("Un investigador de 3 de vida, ataca a un monstruo con 5 de vida, infligiendo un 10% del danio ocasionado al investigador" +
      "que se encuentra en la misma habitacion") {
      val bate = new Arma with ArmaEsfuerzoFisico with ArmaMalditaQueInfligeDanioAOtros
      val investigador = new Investigador(3, 5) with ConArma
      val investigadorDaniado = new Investigador(2, 6)
      val monstruo = new Monstruo(5)
      val habitacion = new Habitacion

      investigador.equiparArma(bate)
      habitacion.agregarHabitante(investigador)
      habitacion.agregarHabitante(investigadorDaniado)
      habitacion.agregarHabitante(monstruo)

      investigador.atacar()

      monstruo.vida shouldBe 0.5
      investigadorDaniado.vida shouldBe 1.55
    }
  }
}