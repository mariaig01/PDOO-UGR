/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

import java.util.ArrayList;
import java.util.Collections;


/**
 *
 * @author angus
 */
public class Tablero {
    
    private ArrayList<Casilla> casillas;
    boolean porSalida;
    
    public Tablero(){
    
        casillas = new ArrayList<>();
        
        Casilla casilla0 = new Casilla(TipoCasilla.DESCANSO,"SALIDA",7500,0,0);
        
        casillas.add(casilla0);
        
        porSalida = false;
    
    }
    
    private boolean correcto(int numCasilla){
    
        if(numCasilla>0 && numCasilla<=20)
                return true;
        else
            return false;
            
    }
    
    public boolean computarPasoPorSalida(){
    
        return porSalida=false;
        
    }
    
    public void añadeCasilla (Casilla casilla){
        
        casillas.add(casilla);
    
    }
    
    public Casilla getCasilla (int numCasilla){
    
        if(correcto(numCasilla))
            return casillas.get(numCasilla);
        else
             return null;
    
    }
    
    public int nuevaPosicion (int actual, int tirada){
    
        int nueva_pos = actual+tirada;
           if(nueva_pos>casillas.size()){
           
           nueva_pos= nueva_pos%casillas.size();
           porSalida=true;
           
           }
    
           return nueva_pos;
    }
}
