/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

/**
 *
 * @author angus
 */

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;


public class Dado {
    
    
    private Random  random ;
    private int ultimoResultado;
    private boolean debug;
    static final private Dado instance = new Dado();
    
    private Dado(){
        //revisar que sea del 1 al 6
        random = new Random();
        ultimoResultado=random.nextInt(5) +1;
        debug=false;
        
    }
    
    static public Dado getInstance(){
        return instance;
    }
    
    public int tirar(){
    
        if(!debug){
            ultimoResultado=random.nextInt(5)+1;
        }
        else
            ultimoResultado=1;
        
        return ultimoResultado;
        
    }
    
    public int quienEmpieza(int n){
    
        return random.nextInt(n);
    }
    
    void setDebug (boolean d){
    
        debug = d;
        
        //También deja constancia en el diario del modo en el que se ha puesto el dado (utilizando el método ocurreEvento de Diario).
      Diario diario = Diario.getInstance();
      String modoDado;
      
      if(!debug)
          modoDado="El modo del dado es falso";
      else
          modoDado="El modo del dado es true";
      
      diario.ocurreEvento(modoDado);
    }
    
    int getUltimoResultado(){
        return ultimoResultado;
    }
}
