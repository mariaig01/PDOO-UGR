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

public class SorpresaPorCasaHotel extends Sorpresa{
    
    SorpresaPorCasaHotel(String texto, int valor){
        super(texto,valor);
    }
    
     void aplicarAJugador(int actual,ArrayList<Jugador> todos){
        informe(actual, todos);
        todos.get(actual).modificaSaldo(valor*todos.get(actual).cantidadCasasHoteles());
    }
     
    void informe(int actual,ArrayList<Jugador> todos){
     Diario.getInstance().ocurreEvento("Se le está aplicando una sopresa de tipo PorCasaHotel al jugador "+ todos.get(actual).getNombre());
    }
     
}
