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
public class SorpresaConvertirme extends Sorpresa{
    
     SorpresaConvertirme(String texto,int valor){
        super(texto,valor);
    }
     
    /*ArrayList<JugadorEspeculador> aplicarAJugador2(int actual,ArrayList<Jugador> todos){
      informe(actual,todos);
      ArrayList<JugadorEspeculador> jugador = new ArrayList();


      for(int i=0;i<todos.size();i++){
        jugador.add(todos.get(i).convertir());
      }

      return jugador;
    }*/
     
     @Override
    void aplicarAJugador(int actual,ArrayList<Jugador> todos){
       if(todos.get(actual) != null){
            informe(actual,todos);
            JugadorEspeculador especulador = todos.get(actual).convertir();
            todos.set(actual, especulador);
        }
      
    }
     
     void informe(int actual,ArrayList<Jugador> todos){
     Diario.getInstance().ocurreEvento("Se le está aplicando una sopresa de tipo Convertirme a JugadorEspeculador "+ todos.get(actual).getNombre());
    }

  
}
