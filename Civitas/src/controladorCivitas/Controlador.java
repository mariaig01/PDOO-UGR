/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorCivitas;
import GUI.CivitasView;
import civitas.CivitasJuego;
import civitas.OperacionJuego;
import civitas.OperacionInmobiliaria;
import civitas.GestionInmobiliaria;
//import GUI.VistaTextual;
import GUI.Dado;

/**
 *
 * @author María
 */
public class Controlador {
    private CivitasJuego juego;
    //private VistaTextual vista;
    private CivitasView vista;
    
    public Controlador(CivitasJuego juego, CivitasView vista){
        this.juego = juego;
        this.vista = vista;
    }
    
    public void juega(){
        
        OperacionJuego op;
        while(!juego.finalDelJuego()){
           vista.actualiza();
            vista.pausa();
            
            op = juego.siguientePaso();
            vista.mostrarSiguienteOperacion(op);
            
            if(op != OperacionJuego.PASAR_TURNO){
                vista.mostrarEventos();
            }
            
            boolean finalizado = juego.finalDelJuego();
            
            if(!finalizado){
                if (op == OperacionJuego.COMPRAR){
                    Respuesta respuesta = vista.comprar();
                    if(respuesta == Respuesta.SI)
                        juego.comprar();
                    juego.SiguientePasoCompletado(op); 
                }
                
                else if (op == OperacionJuego.GESTIONAR){
                    OperacionInmobiliaria oper = vista.elegirOperacion();
           
                    if (oper != OperacionInmobiliaria.TERMINAR){
                        int propiedad = vista.elegirPropiedad();
                        GestionInmobiliaria gestion = new GestionInmobiliaria(oper,propiedad);
                    
                        if (gestion.getOperacion() == OperacionInmobiliaria.CONSTRUIR_CASA){
                            juego.construirCasa(propiedad);
                        }
                        
                        else if(gestion.getOperacion() == OperacionInmobiliaria.CONSTRUIR_HOTEL){
                            juego.construirHotel(propiedad);
                        }
                    }
                    
                    else
                        juego.SiguientePasoCompletado(op);
                }
            }
        }
        
        vista.actualiza(); //incluye tanto el estado actual como el ranking.
    
    }
}
