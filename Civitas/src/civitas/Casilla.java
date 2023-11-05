/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

/**
 *
 * @author Rocío
 */

import java.util.ArrayList;

public class Casilla {
    
    String nombre;
   

    public Casilla (String nombre){
        this.nombre = nombre;
    }
    
    public Casilla(){
        nombre="";
    }
    
    public String getNombre(){
        return nombre;
    }
    
    void Informe(int iactual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("El jugador " + todos.get(iactual).getNombre() + " ha caido en la casilla " + nombre);
        System.out.println(toString());
    }
    
    
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
            Informe(iactual, todos);
    }
    
    
    public String toString(){
        String resultado = "";
        resultado= ("Zona de descanso: "+ nombre);
        return resultado;
    }
   
   
    
}
