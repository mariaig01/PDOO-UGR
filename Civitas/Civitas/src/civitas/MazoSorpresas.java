/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

/**
 *
 * @author angus
 */

import java.util.ArrayList;
import java.util.Collections;

public class MazoSorpresas {
    
      private ArrayList<Sorpresa> sorpresas;
      private boolean barajada;
      private int usadas;
      private boolean debug;
      
      private void init (){
          sorpresas = new ArrayList();
          barajada=false;
          usadas=0;
      
      }
      
      public MazoSorpresas(boolean d){
      
          debug = d;
          init();
          
          if(debug==true){
             Diario diario = Diario.getInstance();
          String mododebug="El modo debug está activado";
              diario.ocurreEvento(mododebug);
          }
              
      
      }
      
      public MazoSorpresas(){
      
          init();
          debug=false;
      }
      
      public void añadeSorpresa(Sorpresa sorpresa){
      
         sorpresas.add(sorpresa);
      }
    
      public void alMazo (Sorpresa s){
          
          if(barajada==false)
              añadeSorpresa(s);
      }
      
      public Sorpresa siguiente (){
      
           if(!barajada || usadas==sorpresas.size()){
               if(!debug){
                   Collections.shuffle(sorpresas);
                   usadas=0;
                   barajada=true;
               }
           
           }
           
           usadas++;
           Sorpresa aux;
           aux=sorpresas.get(0);
           sorpresas.remove(0);
           sorpresas.add(aux);
           
           return aux;
      
      }
}
