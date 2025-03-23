package oo2.ejercicio2;

public class Tijera implements Jugada {
    @Override
    public String jugarContra(Jugada j) {
        return j.jugarContraTijera();
    }

    @Override
    public String jugarContraPiedra() {
        return "Gana Piedra";
    }

    public String jugarContraTijera() {
        return "Empate";
    }

    @Override
    public String jugarContraPapel() {
        return "Gana Tijera";
    }
}
