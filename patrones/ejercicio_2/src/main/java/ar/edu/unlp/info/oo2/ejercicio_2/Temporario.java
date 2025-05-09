package ar.edu.unlp.info.oo2.ejercicio_2;

public class Temporario extends Personal{
    private int cantHoras;
    private boolean casado;
    private int cantHijos;

    public Temporario(int cantHoras, boolean casado, int cantHijos) {
        this.cantHoras = cantHoras;
        this.casado = casado;
        this.cantHijos = cantHijos;
    }

    @Override
    public int basico() {
        return 20000 + this.cantHoras*300;
    }

    @Override
    public int adicional() {
        int total = 0;
        if(this.casado) total += 5000;
        total += this.cantHijos * 2000;
        return total;
    }
}
