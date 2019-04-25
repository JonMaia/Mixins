import `object`.MansionesUtils
import clases.{Arma, Habitacion, Investigador, Monstruo}
import mixins.arma.ConArma
import mixins.arma.Desgastes.ArmaFragil
import org.scalatest.{FunSpec, Matchers}

class ArmaFragilSpec extends FunSpec with Matchers {
  describe("Investigador.atacar() con un arma frágil") {
    it("Un investigador ataca a un monstruo con una escopeta vieja y esta no disparó") {
      MansionesUtils.activar()
      val escopetaVieja = new Arma with ArmaFragil
      val investigador = new Investigador(5, 10) with ConArma
      val monstruo = new Monstruo(20)
      val habitacion = new Habitacion

      investigador.equiparArma(escopetaVieja)
      investigador.entrarEnHabitacion(habitacion)
      monstruo.entrarEnHabitacion(habitacion)

      investigador.atacar()

      monstruo.vida shouldEqual 20
    }
  }

}
