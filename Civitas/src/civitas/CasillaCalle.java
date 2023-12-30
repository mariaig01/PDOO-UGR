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
public class CasillaCalle extends Casilla{
    
    private int numCasas;
    private int numHoteles;
    private float precioCompra;
    private float precioEdificar;
    private float precioBaseAlquiler;
    private static float FACTORALQUILERCALLE = 1.0f;
    private static float FACTORALQUILERCASA = 1.0f;
    private static float FACTORALQUILERHOTEL = 4.0f; 
    private Jugador propietario;
  
    
    CasillaCalle(String nombre){
        super(nombre);
        init();
    }
    
    public CasillaCalle(String nombre, float precioc, float precioe, float precioba){
    
        super(nombre);
        precioCompra = precioc;
        precioEdificar = precioe;
        precioBaseAlquiler = precioba;
        numCasas = 0;
        numHoteles = 0;
    
    }
    
    int cantidadCasasHoteles(){
        return (numCasas+numHoteles);
    }
    
     boolean comprar(Jugador jugador){
       /* propietario = jugador;
        return jugador.paga(precioCompra);*/
       propietario = jugador;
        propietario.paga(precioCompra);
        return true;
    }
     
     private void init(){
        precioCompra = 0;
        precioEdificar = 0;
        precioBaseAlquiler = 0;
        numCasas = 0;
        numHoteles = 0;
        propietario=null;
    }
     
     boolean construirCasa(Jugador jugador){
      /*  boolean result = jugador.paga(precioEdificar);
        numCasas++;
        return result;*/
        
        jugador.paga(precioEdificar);
        this.numCasas++;
        return true;
    }
     
     boolean construirHotel(Jugador jugador){
        /*boolean result = jugador.paga(precioEdificar);
        numHoteles++;
        derruirCasas(numCasas, jugador);
        return result;*/
        
         jugador.paga(precioEdificar);
        this.numHoteles++;
        return true;
    }
    
    boolean derruirCasas(int n, Jugador jugador){
      /* boolean seRealiza = false;
        if (esEsteElPropietario(jugador) && numCasas >= n){
            numCasas -= n;
            seRealiza = true;
        }
        
        return seRealiza;*/
      
       boolean aux=false;
        if(this.esEsteElPropietario(jugador) && n<=numCasas){
            aux=true;
            numCasas=numCasas-n;
        }
        return aux;
    }
    
    public boolean esEsteElPropietario(Jugador jugador){
        boolean es_propietario = false;
        if (propietario == jugador)
            es_propietario = true;
        
        return es_propietario; 
    }
    
    public int getNumCasas(){
        return numCasas;
    }
    
    public int getNumHoteles(){
        return numHoteles;
    }
    
    float GetPrecioAlquilerCompleto(){
        float precio_completo = precioBaseAlquiler * (FACTORALQUILERCALLE + 
                numCasas * FACTORALQUILERCASA +numHoteles*FACTORALQUILERHOTEL);
        return precio_completo;
    }
    
    float getPrecioCompra(){
        return precioCompra;
    }
    
    float getPrecioEdificar(){
        return precioEdificar;
    }
    
     
    @Override
     void recibeJugador(int iactual, ArrayList<Jugador> todos){
      /* Informe(iactual,todos);
        Jugador jugador = todos.get(iactual);
        if (!tienePropietario())
            jugador.puedeComprarCasilla();
        else
            tramitarAlquiler(jugador);*/
      
       Informe(iactual,todos);
    
        if(!tienePropietario()){
            todos.get(iactual).puedeComprarCasilla();
        }
        else{
            this.tramitarAlquiler(todos.get(iactual));
        }
    }
     
     public boolean tienePropietario(){
         
        boolean tiene=true;
         
      if (propietario==null)
            tiene=false;
        
        return tiene;
        
        
       // return (propietario.getNombre() !=  "");
    }
     
    @Override
     public String toString(){
        /*String resultado = "";
        if(tienePropietario()){
            resultado = ("Nombre: " + getNombre() + "\nPropietario: " + propietario.getNombre());
        }
        
        else{
                resultado= ("Sin propietario \nNombre: " + getNombre() + "\nPrecio compra: " + precioCompra + "\nPrecio Edificar: " + precioEdificar 
                    + "\nPrecio Alquiler Base " + precioBaseAlquiler + "\n Numero Casas: " + numCasas + "\n Numero Hoteles: " + numHoteles);
         
        }
        return resultado;*/
        
            String aux;
        if(this.tienePropietario()){
            aux="Nombre: "+ super.getNombre() + "\nPropietario: "+ propietario.getNombre() + "\nCasas: " + numCasas + "\nHoteles: " + numHoteles + "\nPrecio alquiler: " + Float.toString(GetPrecioAlquilerCompleto()) + "\nPrecio Edificar: " +  precioEdificar;
        }else{
            aux= ("Sin propietario \n Nombre: "+super.getNombre() + "\nPrecio compra: " + precioCompra + "\nEdificar: " + precioEdificar 
                    + "\nAlquiler Base " + precioBaseAlquiler );
        } 
        return aux;
    }

    public  void tramitarAlquiler(Jugador jugador){
           /* if (tienePropietario()){
                if (!esEsteElPropietario(jugador)){
                    jugador.pagaAlquiler(precioBaseAlquiler);
                    propietario.recibe(precioBaseAlquiler); 
                } 
            }*/
           
             if(this.tienePropietario() && !this.esEsteElPropietario(jugador)){
            jugador.pagaAlquiler(this.GetPrecioAlquilerCompleto());
            propietario.recibe(this.GetPrecioAlquilerCompleto());
        }
    }
    
    void actualizaPropietarioPorConversion(Jugador j){
        this.propietario=j;
    }
}
