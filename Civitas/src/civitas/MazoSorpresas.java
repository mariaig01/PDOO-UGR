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
import java.util.Collections;

public class MazoSorpresas {
    
    private boolean barajada;
    private boolean debug;
    private ArrayList<Sorpresa> sorpresas;
    private int usadas;
    
    private void init(){
        sorpresas = new ArrayList<>();
        barajada = false;
        usadas = 0; 
    }
    
    MazoSorpresas(boolean d){
        init();
        debug = d;
        
        if (debug){
            String modoMazoSorpresas = "El modo debug esta activad0.";
            Diario.getInstance().ocurreEvento(modoMazoSorpresas);
        }    
    }
    
    MazoSorpresas(){
        init();
        debug = false;
    }
    
    public void alMazo(Sorpresa s){
        if (!barajada)
            añadeSorpresa(s); 
    }
    
    //He creado este método para añadir sorpresas al mazo
    public void añadeSorpresa(Sorpresa sorpresa){
        sorpresas.add(sorpresa); 
    }
    
    public Sorpresa siguiente(){
        
        if (!barajada || usadas == sorpresas.size()){
            if (!debug){
                Collections.shuffle(sorpresas);
                usadas = 0;
                barajada = true;
            }
        }
        usadas+=1;
        Sorpresa aux;
        aux = sorpresas.get(0);
        sorpresas.remove(0);
        sorpresas.add(aux);
        
        return aux;
    }
     
}
