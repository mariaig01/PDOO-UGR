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

public class CivitasJuego {
    
    EstadoJuego estado;
    private int indiceJugadorActual;
    ArrayList<Jugador> jugadores = new ArrayList<>();
    MazoSorpresas mazo;
    Tablero tablero = new Tablero();
    
    public CivitasJuego(ArrayList<String> nombres, boolean debug){
        for(int i=0; i<nombres.size(); i++)
            jugadores.add(new Jugador(nombres.get(i)));
        
        GestorEstados gestor_estados = new GestorEstados();
        estado = gestor_estados.estadoInicial();
        Dado.getInstance().setDebug(debug);
        indiceJugadorActual = Dado.getInstance().quienEmpieza(jugadores.size());
        mazo = new MazoSorpresas(debug);
        tablero = new Tablero();
        inicializaTablero(mazo);
        inicializaMazoSorpresas();
    }
    
    void avanzaJugador(){
        int posicionNueva = tablero.nuevaPosicion(jugadores.get(
                indiceJugadorActual).getCasillaActual(), Dado.getInstance().
                tirar());

        contabilizarPasosPorSalida();

        jugadores.get(indiceJugadorActual).moverACasilla(posicionNueva);

        tablero.getCasilla(posicionNueva).recibeJugador(indiceJugadorActual, 
                jugadores);
    }

    
    
    public boolean comprar(){
        /*Jugador jugadorActual = getJugadorActual();
        int numCasillaActual = jugadorActual.getCasillaActual();
        CasillaCalle casilla = (CasillaCalle) tablero.getCasilla(numCasillaActual);
        boolean res = jugadorActual.comprar(casilla);
        return res;*/
        
        boolean res;
        Jugador jugadorActual = this.getJugadorActual();
        int numCasillaActual=jugadorActual.getCasillaActual();
        CasillaCalle casilla = (CasillaCalle) tablero.getCasilla(numCasillaActual);
        res= jugadorActual.comprar(casilla);
        return res;
    }
   
    
    public boolean construirCasa(int ip){
        return jugadores.get(indiceJugadorActual).construirCasa(ip);
    }
    
    public boolean construirHotel(int ip){
        return jugadores.get(indiceJugadorActual).construirHotel(ip);
    }
    
    private void contabilizarPasosPorSalida(){
        if(tablero.computarPasoPorSalida())
            jugadores.get(indiceJugadorActual).pasaPorSalida();
    }
    
   public boolean finalDelJuego () {
       boolean fin = false;
        for (int i = 0; i < jugadores.size(); ++i)
            if (jugadores.get(i).enBancarrota())
                fin = true;

        return fin;
    }

    
    public Casilla getCasillaActual(){
        return tablero.getCasilla(jugadores.get(indiceJugadorActual).getCasillaActual());
    }
    
    public int getIndiceJugadorActual(){
        return indiceJugadorActual;
    }
    
    public Jugador getJugadorActual(){
        return jugadores.get(indiceJugadorActual);
        
    }
    
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    
    public Tablero getTablero(){
        return tablero;
    }
    
    private void inicializaMazoSorpresas(){
        mazo.alMazo(new SorpresaPagarCobrar("PAGAR", -100));
        mazo.alMazo(new SorpresaPagarCobrar("PAGAR", -200));
        mazo.alMazo(new SorpresaPagarCobrar("PAGAR", -300));
        mazo.alMazo(new SorpresaPagarCobrar("COBRAR", 100));
        mazo.alMazo(new SorpresaPagarCobrar("COBRAR", 200));
        mazo.alMazo(new SorpresaPagarCobrar("COBRAR", 300));
        mazo.alMazo(new SorpresaPorCasaHotel("PAGAR POR CASA HOTEL", -100));
        mazo.alMazo(new SorpresaPorCasaHotel("PAGAR POR CASA HOTEL", -200));
        mazo.alMazo(new SorpresaPorCasaHotel("COBRAR POR CASA HOTEL", 100));
        mazo.alMazo(new SorpresaPorCasaHotel("COBRAR POR CASA HOTEL", 200));
    }
    
    private void inicializaTablero(MazoSorpresas mazo){
        tablero.añadeCasilla(new CasillaCalle("Gracia",200,70,30));
        tablero.añadeCasilla(new CasillaCalle( "Recogidas", 100, 50, 20));
        tablero.añadeCasilla(new CasillaCalle("Buensuceso", 100, 60, 20));
        tablero.añadeCasilla(new CasillaSorpresa("SORPRESA", mazo));
        tablero.añadeCasilla(new CasillaCalle("Tablas", 100, 70, 950));
        tablero.añadeCasilla(new CasillaCalle("Ángel", 200, 200,200));
        tablero.añadeCasilla(new CasillaSorpresa("SORPRESA", mazo));
        tablero.añadeCasilla(new CasillaCalle("Mirlo", 100, 150, 200));
        tablero.añadeCasilla(new CasillaCalle("Ruiseñor", 100, 160, 650));
        tablero.añadeCasilla(new Casilla("PARKING"));
        tablero.añadeCasilla(new CasillaCalle("Cisne", 590, 100, 600));
        tablero.añadeCasilla(new CasillaCalle( "Goya", 900, 280, 910));
        tablero.añadeCasilla(new CasillaSorpresa("SORPRESA", mazo));
        tablero.añadeCasilla(new CasillaCalle("Paz", 880, 260,850));
        tablero.añadeCasilla(new CasillaCalle("Cruz", 890, 270, 900)); 
        tablero.añadeCasilla(new CasillaSorpresa("SORPRESA", mazo));
        tablero.añadeCasilla(new CasillaCalle("Elena", 400, 800, 500));
        tablero.añadeCasilla(new CasillaCalle("Torres", 300, 600, 300));
        tablero.añadeCasilla(new CasillaCalle("Averroes", 200, 550, 290));
        tablero.añadeCasilla(new CasillaCalle("Águila", 100, 320, 120));
    }
    
    private void pasarTurno(){
        if(indiceJugadorActual==(jugadores.size()-1)){
            indiceJugadorActual=0;
        }
        else{
            indiceJugadorActual++;
        }
    }
    
    public ArrayList<Jugador> ranking(){
        Collections.sort(jugadores, Collections.reverseOrder());
        return jugadores;
    }
    
    public String mostrarRanking(){
        ArrayList<Jugador> ranking_ = ranking();
        String cadena="";
        
        for(int i=0;i<ranking_.size();i++){
            cadena+=ranking_.get(i).toString();
            cadena+="\n";
        }
        return cadena;
    }
    
    public OperacionJuego siguientePaso(){
        Jugador jugadorActual = getJugadorActual();
        OperacionJuego operacion =  new GestorEstados().siguienteOperacion(jugadorActual, estado);
        
        if (operacion == OperacionJuego.PASAR_TURNO){
            pasarTurno();
            SiguientePasoCompletado(operacion);
        }
        
        else if (operacion == OperacionJuego.AVANZAR){
            avanzaJugador();
            SiguientePasoCompletado(operacion);
        }
        
        return operacion;
    }
    
    public void SiguientePasoCompletado(OperacionJuego operacion){
        estado = new GestorEstados().siguienteEstado(getJugadorActual(), estado, operacion);
    } 
    
}
