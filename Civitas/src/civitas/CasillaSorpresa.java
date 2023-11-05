/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

import java.util.ArrayList;

/**
 *
 * @author angus
 */
public class CasillaSorpresa extends Casilla {
    
      private MazoSorpresas mazo;
      private Sorpresa sorpresa;
    
    CasillaSorpresa(String nombre,MazoSorpresas mazo){
        super(nombre);
        init();
        this.mazo=mazo;
    }
    
    private void init(){
        mazo = null;
    }
    
      @Override
     void recibeJugador(int iactual, ArrayList<Jugador> todos){
        /*Informe(iactual, todos);
        mazo.siguiente().aplicarAJugador(iactual,todos);*/
        
        sorpresa = mazo.siguiente();
        Informe(iactual,todos);
        sorpresa.aplicarAJugador(iactual, todos);
    }
     
      @Override
     public String toString(){
        String resultado = "";
        resultado = ("Casilla Sorpresa: "+ nombre);
        return resultado;
    }
   
}
