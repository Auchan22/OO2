package oo2.ejercicio2;

public class Jugador {
    private String nombre;
    private Jugada jugada;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setJugada(Jugada jugada) {
        this.jugada = jugada;
    }

    public String jugar(Jugada j) {
        return this.jugada.jugarContra(j);
    }
}
