package oo2.ejercicio2;

public class Piedra implements Jugada {
    @Override
    public String jugarContra(Jugada j) {
        return j.jugarContraPiedra();
    }

    @Override
    public String jugarContraPiedra() {
        return "Empate";
    }

    public String jugarContraTijera() {
        return "Gana Piedra";
    }

    @Override
    public String jugarContraPapel() {
        return "Gana Papel";
    }
}
