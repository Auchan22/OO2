package ar.edu.unlp.info.oo2.ejercicio_2;

public class Pasante extends Personal{
    private int cantExamen;

    public Pasante(int cantExamen) {
        this.cantExamen = cantExamen;
    }

    @Override
    public int basico() {
        return 20000;
    }

    @Override
    public int adicional() {
        return 2000*cantExamen;
    }
}
