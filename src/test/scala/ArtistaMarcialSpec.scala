import `object`.MansionesUtils
import clases.{Habitacion, Investigador, Monstruo}
import mixins.luchador.ArtistaMarcial
import org.scalatest.{FunSpec, Matchers}

class ArtistaMarcialSpec extends FunSpec with Matchers {

  describe("ArtistaMarcial.atacar") {
    MansionesUtils.activar()
    it("Un artista marcial cuando ataca, causa un 50 % más de daño") {
      val artistaMarcial = new Investigador(5, 20) with ArtistaMarcial
      val monstruo = new Monstruo(20)
      val habitacion = new Habitacion()

      MansionesUtils.state = true

      artistaMarcial.entrarEnHabitacion(habitacion)
      monstruo.entrarEnHabitacion(habitacion)

      artistaMarcial.atacar()      // Al atacar, lo hace con un danio controlado de 5, mas el 50%.

      monstruo.vida shouldEqual 12.5 // Le ocaciona 7.5 de daño.


    }

  }

}
