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
public class Tablero {
    
    private boolean porSalida;
    private ArrayList<Casilla> tablero;
    static final int NUM_CASILLAS = 20;
    
    public Tablero(){
        
        tablero = new ArrayList<Casilla>();
        Casilla Salida=new Casilla( "SALIDA");;
        //Salida = new Casilla(TipoCasilla.DESCANSO, "SALIDA");
        tablero.add(Salida);
        porSalida = false;  
    }
    
    void añadeCasilla(Casilla casilla){
        tablero.add(casilla);
    }
    
    public boolean computarPasoPorSalida(){
        return porSalida = false;
    }
    
    private boolean correcto (int numCasilla){
        
        boolean es_correcto = false;
        
        if(numCasilla >= 0 && numCasilla < NUM_CASILLAS)
            es_correcto = true;
        
        return es_correcto; 
    }
    
     public ArrayList<Casilla> getCasillas(){
        return tablero;
    }
    
    public Casilla getCasilla (int numCasilla){
        
        if (correcto(numCasilla))
            return tablero.get(numCasilla);
        
        else 
            return null;
    }
    
    int nuevaPosicion(int actual, int tirada){
        
        int nueva_pos = actual + tirada;
        
        
        if (nueva_pos >= NUM_CASILLAS){
            
            nueva_pos = nueva_pos % NUM_CASILLAS;
            porSalida = true;
        }
        
        return nueva_pos;
   
    } 
}
