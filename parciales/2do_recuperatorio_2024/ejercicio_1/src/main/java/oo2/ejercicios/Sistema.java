package oo2.ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Jugador> jugadores;

    public Sistema() {
        jugadores = new ArrayList<Jugador>();
    }

    public Jugador registrarJugador(String nombre, int capacidad){
        Bolsa b = new Bolsa(1, "Bolsa", capacidad);
        Jugador j = new Jugador(nombre, b);
        this.jugadores.add(j);
        return j;
    }
}
