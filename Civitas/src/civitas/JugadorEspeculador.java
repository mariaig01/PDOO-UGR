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
public class JugadorEspeculador extends Jugador {
    
    private static int FactorEspeculador=2;
    protected static int CasasMax = 4*FactorEspeculador;
    protected static int HotelesMax = 4*FactorEspeculador;
    
    JugadorEspeculador(Jugador otro){
        super(otro);
        actualizaPropiedadesPorConversion(this);
    }
    
    @Override
    public int getCasasMax(){
        return CasasMax;
    }
    
    @Override
     public int getHotelesMax(){
        return HotelesMax;
    }
     
     void actualizaPropiedadesPorConversion(JugadorEspeculador otro){
         for(int i=0;i<super.getPropiedades().size();i++)
         super.getPropiedades().get(i).actualizaPropietarioPorConversion(otro);
     }
     
     @Override
     public String toString(){
    String informacion = "El jugador especulador "+ nombre + " se encuentra actualmente en la casilla " + casillaActual + "\nSu saldo es: " + Float.toString(saldo) + "\nTiene las siguientes propiedades";
        for(int i=0; i < propiedades.size(); i++){
            informacion += propiedades.get(i).getNombre() + "\tNumero Casas: " + propiedades.get(i).getNumCasas() + "\tNumero Hoteles: " + propiedades.get(i).getNumHoteles();
            informacion += "\n";
        }
        
        informacion += "\n Las casas máximas son "+CasasMax+" y los hoteles máximos son "+HotelesMax+"\n";
        
        return informacion;
    }
}
