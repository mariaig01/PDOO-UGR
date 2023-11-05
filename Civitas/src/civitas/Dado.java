/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

/**
 *
 * @author Rocío
 */
import java.util.Random;
import java.util.ArrayList;

public class Dado {
    
    static private int VALORES = 5;
    static private int VALOR_I = 1;
    static final private Dado instance = new Dado();
    private Random random;
    private int ultimoResultado;
    private boolean debug;
    
    static public Dado getInstance(){
        return instance;
    }
    
    public int getUltimoResultado(){
        return ultimoResultado;
    }
    
    private Dado(){
        
        random = new Random();
        ultimoResultado = random.nextInt(VALORES)+VALOR_I;
        debug = false;
    }
    
    public int tirar(){
        if (!debug)
            ultimoResultado = random.nextInt(VALORES)+VALOR_I;
        else
            ultimoResultado = VALOR_I;
        
        return ultimoResultado;  
    }
    
    public int quienEmpieza(int n){
        
        int quien_empieza = random.nextInt(n);
        return quien_empieza;
        
    }
    
    public void setDebug(boolean d){
        debug = d;
        String modoDado;
        
        if (!debug)
            modoDado = "El modo del dado es falso";
        else
            modoDado = "El modo del dado es true";
        
        Diario.getInstance().ocurreEvento(modoDado);
        
    }
    
    public boolean GetDebug(){
        return debug;
    }
    
}
