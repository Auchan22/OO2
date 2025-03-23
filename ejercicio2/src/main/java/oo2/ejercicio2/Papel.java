package oo2.ejercicio2;

public class Papel implements Jugada {
    @Override
    public String jugarContra(Jugada j) {
        return j.jugarContraPapel();
    }

    @Override
    public String jugarContraPiedra() {
        return "Gana Papel";
    }

    public String jugarContraTijera() {
        return "Gana Tijera";
    }

    @Override
    public String jugarContraPapel() {
        return "Empate";
    }
}
