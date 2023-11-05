/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

/**
 *
 * @author Rocío
 */
import static civitas.JugadorEspeculador.CasasMax;
import static civitas.JugadorEspeculador.HotelesMax;
import java.util.ArrayList;
import java.util.Collections;

public class Jugador implements Comparable<Jugador>{
    
    protected static int CasasMax = 4;
    protected static int CasasPorHotel = 4;
    int casillaActual;
    protected static int HotelesMax = 4;
    String nombre;
    protected static float PasoPorSalida = 1000;
    ArrayList<CasillaCalle> propiedades;
    boolean puedeComprar;
    float saldo;
    static float SaldoInicial = 7500;
    
    
    Jugador(String nombre){
        this.nombre = nombre;
        saldo = SaldoInicial;
        casillaActual = 0;
       // puedeComprar = true;
        puedeComprar = false;
        propiedades = new ArrayList<CasillaCalle>();
    }
    
         
    protected Jugador(Jugador otro){
        nombre = otro.nombre;
        saldo = otro.saldo;
        casillaActual = otro.casillaActual;
        puedeComprar = otro.puedeComprar;
        propiedades = otro.propiedades;
        
    }
    
    int cantidadCasasHoteles(){
        
         int cantidad=0;
        for (int i=0; i< propiedades.size(); i++){
            cantidad += propiedades.get(i).cantidadCasasHoteles();
        }
        return cantidad;
        
       // return propiedades.size();
    }
    
    public int compareTo(Jugador otro){
        return Float.compare(saldo, otro.saldo);
    }
    
    /*boolean comprar(Casilla titulo){
        boolean result = false;
        if (puedeComprar){
            float precio = titulo.getPrecioCompra();
            
            if(puedoGastar(precio)){
                result = titulo.comprar(this);
                propiedades.add(titulo);
                Diario.getInstance().ocurreEvento("El jugador " + this + " compra la propiedad " + titulo);
            }
        }
        
        else
            Diario.getInstance().ocurreEvento("El jugador " + this + " no tiene saldo para comprar la propiedad " + titulo);
        
        return result;  
    }*/
    
    boolean comprar(CasillaCalle titulo){
        boolean result = false;
        
        if (puedeComprar){
            float precio = titulo.getPrecioCompra();
            
            if(puedoGastar(precio)){
                result = titulo.comprar(this);
                if(result){
                propiedades.add(titulo);
                Diario.getInstance().ocurreEvento("El jugador " + this + " compra la propiedad " + titulo);
                }
            }
        }
        
        else
            Diario.getInstance().ocurreEvento("El jugador " + this + " no tiene saldo para comprar la propiedad " + titulo);
        
        return result;  
       
    }
    
    boolean construirCasa(int ip){
        boolean result = false;
        boolean existe = existeLaPropiedad(ip);
        if (existe){
            CasillaCalle propiedad = (CasillaCalle) propiedades.get(ip);
            boolean puedoEdificar = puedoEdificarCasa(propiedad);
            float precio = propiedad.getPrecioEdificar();
            if (puedoEdificar){
                result = propiedad.construirCasa(this);
                Diario.getInstance().ocurreEvento(nombre + " construye una casa en la calle " + propiedad.getNombre());

            }
            
            else
                Diario.getInstance().ocurreEvento(nombre + " no construye una casa en la calle " + propiedad.getNombre());
           
        }
        return result; 
    }
    
    /*boolean construirCasa(int ip){
        boolean result = false;
        boolean existe = existeLaPropiedad(ip);
        if (existe){
            CasillaCalle propiedad = propiedades.get(ip);
            boolean puedoEdificar = puedoEdificarCasa(propiedad);
            float precio = propiedad.getPrecioEdificar();
            if (puedoEdificar){
                result = propiedad.construirCasa(this);
                Diario.getInstance().ocurreEvento(nombre + " construye una casa en la calle " + propiedad.getNombre());

            }
            
            else
                Diario.getInstance().ocurreEvento(nombre + " no construye una casa en la calle " + propiedad.getNombre());
           
        }
        return result; 
    }*/
        
    /*boolean construirHotel(int ip){
        boolean result = false;
        if (existeLaPropiedad(ip)){
            Casilla propiedad = propiedades.get(ip);
            boolean puedoEdificarHotel = puedoEdificarHotel(propiedad); 
            
            if(puedoEdificarHotel){
                result = propiedad.construirHotel(this);
                Diario.getInstance().ocurreEvento(nombre + " construye una hotel en la calle " + propiedad.getNombre());
                
            }
            
            else{
                Diario.getInstance().ocurreEvento(nombre + " no construye una hotel en la calle " + propiedad.getNombre());
            }
        }
        return result;
    }*/
        
    
    boolean construirHotel(int ip){
        boolean result = false;
        if (existeLaPropiedad(ip)){
            CasillaCalle propiedad = (CasillaCalle) propiedades.get(ip);
            boolean puedoEdificarHotel = puedoEdificarHotel(propiedad); 
            
            if(puedoEdificarHotel){
                result = propiedad.construirHotel(this);
                Diario.getInstance().ocurreEvento(nombre + " construye una hotel en la calle " + propiedad.getNombre());
                
            }
            
            else{
                Diario.getInstance().ocurreEvento(nombre + " no construye una hotel en la calle " + propiedad.getNombre());
            }
        }
        return result;
    }
        
    
    boolean enBancarrota(){
        return (saldo <= 0);
    }
    
    private boolean existeLaPropiedad(int ip){
        boolean existe = false;
        
        if(ip >= 0 && ip < propiedades.size())
            existe = true;
        
        return existe;
    }
    
    public int getCasasMax(){
        return CasasMax;
    }
    
    public int getCasasPorHotel(){
        return CasasPorHotel;
    }
    
    public int getCasillaActual(){
        return casillaActual;
    }
    
    
    public int getHotelesMax(){
        return HotelesMax;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    private float getPremioPasoSalida(){
        return PasoPorSalida;
    }
    
    /*public ArrayList<Casilla> getPropiedades(){
        return propiedades;
    }*/
    
    public ArrayList<CasillaCalle> getPropiedades(){
        return propiedades;
    }
    
    boolean getPuedeComprar(){
        return puedeComprar;
    
    }
    
    public float getSaldo(){
        return saldo;
    }
    
    boolean modificaSaldo(float cantidad){
       /* saldo += cantidad;
        
        if(cantidad<0){
        Diario.getInstance().ocurreEvento("Se ha decrementado el saldo y ahora vale: " + saldo);
        }
        else{
        Diario.getInstance().ocurreEvento("Se ha incrementado el saldo y ahora vale: " + saldo);
        }
        return true;*/
       
       
       
       saldo+=cantidad;
        Diario.getInstance().ocurreEvento("El saldo del jugador " + this.nombre + " ha variado en " + Float.toString(cantidad));
        return true;
    }
    
    boolean moverACasilla(int numCasilla){
        casillaActual = numCasilla;
        puedeComprar = false;
        Diario.getInstance().ocurreEvento("El jugador se ha movido a la casilla " + casillaActual);
        return true;
    }
    
    boolean paga(float cantidad){
       return modificaSaldo(cantidad*-1); 
    }
    
    boolean pagaAlquiler(float cantidad){
        return paga(cantidad); 
    }
    
    boolean pasaPorSalida(){
        modificaSaldo(PasoPorSalida);
        Diario.getInstance().ocurreEvento("El jugador ha pasado por la salida");
        return true;
    }
    
    boolean puedeComprarCasilla(){
        puedeComprar = true;
        return puedeComprar;
    }
    
    private boolean puedoEdificarCasa (CasillaCalle propiedad) {
        return (puedoGastar(propiedad.getPrecioEdificar()) && propiedad.getNumCasas() < CasasMax);
    }

    private boolean puedoEdificarHotel (CasillaCalle propiedad) {
        return (puedoGastar(propiedad.getPrecioEdificar()) && propiedad.getNumHoteles() < HotelesMax 
                && propiedad.getNumCasas() >= getCasasPorHotel());
    }
    
    private boolean puedoGastar(float precio){
        return (saldo >= precio);
    }
    
    boolean recibe(float cantidad){
       return (modificaSaldo(cantidad));
    }
    
    boolean tieneAlgoQueGestionar(){
       return (propiedades.size() > 0);
    }
    
    public String toString(){
    String informacion = "El jugador "+ nombre + " se encuentra actualmente en la casilla " + casillaActual + 
            "\nSu saldo es: " + Float.toString(saldo) ;
    
    if(propiedades.size()!=0){
        informacion+= "\nTiene las siguientes propiedades: \n";
        for(int i=0; i < propiedades.size(); i++){
            informacion += propiedades.get(i).getNombre() + "\tNumero Casas: " + propiedades.get(i).getNumCasas() + "\tNumero Hoteles: " + propiedades.get(i).getNumHoteles();
            informacion += "\n";
        }
    }
    else
        informacion+="\nNo tiene propiedades";
    
        informacion += "\n Las casas máximas son "+CasasMax+" y los hoteles máximos son "+HotelesMax+"\n";
        
        return informacion;
    }
    
     public String toStringPropiedad(int ip) {
        return propiedades.get(ip).getNombre();
         
    }
    
     JugadorEspeculador convertir(){
         JugadorEspeculador jugador = new JugadorEspeculador(this);
         return jugador;
     }
    
    public boolean esEspeculador(){
    
        if(CasasMax==8 && HotelesMax==8)
            return true;
        else
            return false;
    }
}