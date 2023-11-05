/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;
import java.util.Collections;


/**
 *
 * @author angus
 */


public class Casilla{
    
    TipoCasilla tipo;
    private String Nombre;
    private float precioCompra;
    private float precioEdificar;
    private float precioBaseAlquiler;
    private int numCasas;
    private int numHoteles;
    static private float FACTORALQUILERCALLE=1.0f;
    static private float FACTORALQUILERCASA=1.0f;
    static private float FACTORALQUILERHOTEL=4.0f;
    
    private void init(){
    
            Nombre="";
            precioCompra=0;
            precioEdificar=0;
            precioBaseAlquiler=0;
            numCasas=0;
            numHoteles=0;
        
    }
    
    /*public Casilla (TipoCasilla unTipo, String unNombre, float unPrecioCompra, float unPrecioEdificar, float unPrecioAlquilerBase){
    
        tipo = unTipo;
        Nombre = unNombre;
        precioCompra = unPrecioCompra;
        precioEdificar = unPrecioEdificar;
        precioBaseAlquiler = unPrecioAlquilerBase;
        numCasas = 0;
        numHoteles = 0;
    
    }*/
    
    public Casilla(String n, float precioc, float precioe, float precioba){
    
        Nombre = n;
        precioCompra = precioc;
        precioEdificar = precioe;
        precioBaseAlquiler = precioba;
        numCasas = 0;
        numHoteles = 0;
    
    }
    
    
    
    //Constructor sin parámetros
    //He inicializado todo a 0 ya que es un constructor sin parámetros, y los constructores sirven para inicializar los atributos de la clase
    
    public Casilla(){
    
            Nombre="";
            precioCompra=0;
            precioEdificar=0;
            precioBaseAlquiler=0;
            numCasas=0;
            numHoteles=0;
            
    }
    
    public Casilla(TipoCasilla t,String nombre){
        init();
        t = TipoCasilla.DESCANSO;
        Nombre=nombre;
    
    }
    
    public Casilla(TipoCasilla t,String titulo,float precioCompra,float precioEdificar,float precioBaseAlquiler){
        
        init();
        t = TipoCasilla.CALLE;
        Nombre=titulo;
        this.precioCompra = precioCompra;
        this.precioBaseAlquiler = precioBaseAlquiler;
        this.precioEdificar = precioEdificar;
    
    }
    
    public Casilla(TipoCasilla t,String nombre, MazoSorpresas mazo){
    
        init();
        t = TipoCasilla.SORPRESA;
        Nombre = nombre;
    
    }
    
    //creo que cuando pone ~ en el diagrama de clase significa que no pongamos public a los metodos
    
    boolean comprar(Jugador jugador){
    
    }
    
   public String getNombre(){
       return Nombre;
    }
    
   /*public float getPrecioCompra(){
       return precioCompra;
   }*/
   
   float getPrecioCompra(){
       return precioCompra;
   }
   
   /*public float getPrecioEdificar(){
       return precioEdificar;
   }*/
   
   float getPrecioEdificar(){
       return precioEdificar;
   }
   
   public int getnumCasas(){
       return numCasas;
   }
   
   int getNumCasas(){
       return numCasas;
   }
   
   public int getnumHoteles(){
       return numHoteles;
   }
   
   int getNumHoteles(){
       return numHoteles;
   }
   
  /* public float  getPrecioAlquilerCompleto(){
   
      return precioBaseAlquiler*(FACTORALQUILERCALLE+ numCasas*FACTORALQUILERCASA + numHoteles*FACTORALQUILERHOTEL);
   
   }*/
   
   float getPrecioAlquilerCompleto(){
   
   }
   
   public boolean construirCasa(){
       numCasas++;
       return true;
   }
   
   boolean construirCasa(Jugador jugador){
   
   }
   
   boolean construirHotel(Jugador jugador){
   
   
   }
   
   boolean derruirCasas(int numero ,Jugador jugador){
   
   }
   
   public boolean esEsteElPropietario(Jugador jugador){
   
   }
   
   public boolean construirHotel(){
       numHoteles++;
       return true;
   }
   
   public String toString(){
       
      return tipo+": "+Nombre+". Precios: Compra:"+precioCompra+", Edificar: "+precioEdificar+", AlquilerBase: "+precioBaseAlquiler+", Casas:"+numCasas+", Hoteles: "+numHoteles;
   }
   
   public int cantidadCasasHoteles(){
       return numCasas+numHoteles;
   }
  
   void informe(int iactual,Jugador todos){
   
   }
   
   void recibeJugador(int iactual,Jugador todos){
   
   }
   
   private void recibeJugador_calle(int iactual,Jugador todos){
   
   }
   
   private void recibeJugador_Sorpresa(int iactual,Jugador todos){
   
   
   }
   
   public boolean tienePropietario(){
   
   }
   
   public String toString(){
   
   }
   
   public void tramitarAlquiler(Jugador jugador){
   
   }
   
   
}