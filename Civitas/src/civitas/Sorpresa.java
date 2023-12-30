/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

/**
 *
 * @author María
 */
import java.util.ArrayList;
public abstract class Sorpresa {
    
    String texto;
    int valor;
    
    Sorpresa(String texto, int valor){
   
        this.texto = texto;
        this.valor = valor;
    }
    
    /*void aplicarAJugador(int actual,ArrayList<Jugador> todos){
        if (tipo == TipoSorpresa.PAGARCOBRAR)
            aplicarAJugador_pagarCobrar(actual, todos);
        
        else
            aplicarAJugador_porCasaHotel(actual, todos);
    }*/
    
    /*void aplicarAJugador_pagarCobrar(int actual,ArrayList<Jugador> todos){
        informe(actual, todos);
        todos.get(actual).modificaSaldo(valor);
    }
    
    void aplicarAJugador_porCasaHotel(int actual,ArrayList<Jugador> todos){
        informe(actual, todos);
        todos.get(actual).modificaSaldo(valor*todos.get(actual).cantidadCasasHoteles());
    }
    
    void informe(int actual,ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("Se le está aplicando una sopresa al jugador "+ todos.get(actual).getNombre());
    }*/
    
    abstract void aplicarAJugador(int actual,ArrayList<Jugador> todos);
    
    public String toString(){
        return texto;
    }
}
    
    

