/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package civitas;
import java.util.ArrayList;

/**
 *
 * @author angus
 */


public class Civitas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       int N=100;
       int jugadores=4;
       int jugador1=0;
       int jugador2=0;
       int jugador3=0;
       int jugador4=0;
       int quien_empieza;
       
       
       Dado d = Dado.getInstance();
       
       for(int i=0;i<N;i++){
           quien_empieza=d.quienEmpieza(jugadores);
          
          if(quien_empieza==0)
              jugador1++;
          else if(quien_empieza==1)
              jugador2++;
          else if(quien_empieza==2)
              jugador3++;
          else if(quien_empieza==3)
              jugador4++;
          
       }
       
       System.out.println("Jugador 1: " + jugador1 + "\njugador2: " + jugador2 +
                "\nJugador3: " + jugador3 + "\nJugador4: " + jugador4);
       
       boolean modo=true;
       N=4;
       
       d.setDebug(modo);
       int resultado;
       
       for(int i=0;i<N;i++){
           
           resultado=d.tirar();
           System.out.println("\n"+resultado+"\n");
       }
       
       modo=false;
       
       d.setDebug(modo);
       
        for(int i=0;i<N;i++){
           
           resultado=d.tirar();
           System.out.println("\n"+resultado+"\n");
       }
        
       int ultimores = d.getUltimoResultado();
       
       System.out.println("\n"+ultimores+"\n");
       
       TipoCasilla t_casilla;
       t_casilla = TipoCasilla.CALLE;
       
       TipoSorpresa t_sorpresa;
       t_sorpresa = TipoSorpresa.PAGARCOBRAR;
       
       EstadosJuego e_juego;
       e_juego = EstadosJuego.DESPUES_AVANZAR;
       
       System.out.println("\nTipoCasilla: "+t_casilla+"\nTipoSorpresa: "+t_sorpresa+"\nEstadosJuego: "+e_juego);
       System.out.println("\n");
       
       Tablero t = new Tablero();
       
       Casilla c1 = new Casilla(TipoCasilla.CALLE,"Calle Buensuceso",5000,400,700);
       Casilla c2 = new Casilla(TipoCasilla.CALLE,"Calle Reyes Católicos",6000,500,800);
       Casilla c3 = new Casilla(TipoCasilla.CALLE,"Calle Pedro Antonio",5500,650,900);
       
       t.añadeCasilla(c1);
       t.añadeCasilla(c2);
       t.añadeCasilla(c3);
       
       Casilla c4;
       
       c4 = t.getCasilla(1);
       
       System.out.println(c4.toString());
       
       c4 = t.getCasilla(2);
       
       System.out.println(c4.toString());
       
       c4 = t.getCasilla(3);
       
       System.out.println(c4.toString());
       
       float preciomayor=0;
       float precio = 0;
       int NCASILLAS=3;
       int casilla = 0;
       
       for(int i=1;i<=NCASILLAS;i++){
           c4 = t.getCasilla(i);
           precio = c4.getPrecioCompra();
           if(precio>preciomayor){
               preciomayor = precio;
               casilla = i;
           }
           
       }
       
       System.out.println("\n La casilla que tiene mayor precio de compra es: "+casilla);
        System.out.println("\n");
        
       precio = 0;
       float preciomenor=0;
       casilla = 0;
       float preciomedio=0;
       
       for(int i=1;i<=NCASILLAS;i++){
           c4 = t.getCasilla(i);
           precio = c4.getPrecioCompra();
           preciomedio+=precio;
           if(precio<preciomayor){
               preciomayor = precio;
               casilla = i;
           }
           
       }
       
       preciomedio = preciomedio/NCASILLAS;
       
       System.out.println("\n La casilla que tiene menor precio de compra es: "+casilla);
       System.out.println("\n");
        
       System.out.println("\n El precio medio de compra es : "+preciomedio+"\n");
     
      Diario diario = Diario.getInstance();
      
      ArrayList<String> eventos;
      
      eventos = diario.getEventos();
      
      System.out.print(eventos);
        
      diario.ocurreEvento("El jugador 1 ha pasado por la salida");
      
      System.out.print(eventos);
      
      boolean eventospendientes;
      
      eventospendientes=diario.eventosPendientes();
      
      System.out.print("\n"+eventospendientes+"\n \n");
      
      diario.leerEvento();
      
      System.out.print(eventos);
      
      c4 = t.getCasilla(casilla);
      
      System.out.println(c4.toString());
      
      int pos = d.tirar();
      int npos=0;
      System.out.println(pos);
      int newpos = t.nuevaPosicion(npos, pos);
      npos=newpos;
      
      System.out.println(newpos);
      
      pos = d.tirar();
      System.out.println(pos);
      
      newpos = t.nuevaPosicion(npos, pos);
      
      System.out.println(newpos);
      
      
      
      
      
     
         
    
    }
    
}
