/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;
import java.util.ArrayList;
/**
 *
 * @author María
 */
public class TestP4 {
    
    public static void main(String[] args){
        
        
        int i;  // Un contador para los bucles
        
//      # Nos preparamos un par de nombres para tener dos jugadores
      
      ArrayList<String> nombres = new ArrayList<>();
      nombres.add ("Vilma");
      
//      # Instanciamos un juego y obtenemos el diario
      // En mi versión puedo poner el modo debug al instanciar el juego (el boolean del segundo parámetro)
      CivitasJuego juego = new CivitasJuego (nombres, true); 
      Diario diario = Diario.getInstance();
      
//      # Se implementa la prueba usando métodos de CivitasJuego y de Diario. Se le envían los mensajes a dichas variables.
      
//      # Durante el transcurso de la prueba se pueden escribir cosas en el diario
      diario.ocurreEvento("Turno de " + juego.getJugadorActual().getNombre());
      
//      # EMPEZAMOS A JUGAR.

//      # Avanzamos al primer jugador 
//      # Recordar que avanzar un jugador es que tire el dado (saldrá 1 al estar en modo debug)
//      # llegue a esa casilla, y le ocurra todo lo que pueda ocurrirle de manera automática
//      # Eso es lo que hace el método  avanza_jugador
      juego.avanzaJugador();
      
//      # Lo que requiere intervención del usuario hay que programarlo
//      # Hay que comprar la propiedad e intentar construir 5 casas
      juego.comprar();
      
//      # Si el juego está bien, este jugador solo tendrá 1 hotel, ya que la 5a casa no debe haberse
//      # edificado y el segundo hotel tampoco
      
//      # Cuanto más completa sea la información que metemos en el diario y la que muestran los métodos toString,
//      # más información tenemos en el momento de las pruebas para comprobar el correcto funcionamiento del software
      
//      # Aunque siempre podemos ver el estado de los objetos que queremos comprobar
      System.out.println (juego.getJugadorActual().toString());
      
        
        JugadorEspeculador j2 = new JugadorEspeculador(juego.getJugadores().get(0));
        
        j2=juego.getJugadores().get(0).convertir();
        
        System.out.println(j2.toString());

    }
}
