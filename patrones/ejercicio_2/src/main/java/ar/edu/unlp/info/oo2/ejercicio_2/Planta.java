package ar.edu.unlp.info.oo2.ejercicio_2;

public class Planta extends Personal{
    private boolean casado;
    private int cantHijos;
    private int aniosAntiguedad;

    public Planta(boolean casado, int cantHijos, int aniosAntiguedad) {
        this.casado = casado;
        this.cantHijos = cantHijos;
        this.aniosAntiguedad = aniosAntiguedad;
    }

    @Override
    public int basico() {
        return 50000;
    }

    @Override
    public int adicional() {
        int total = 0;
        if(this.casado) total += 5000;
        total += this.cantHijos * 2000;
        total += this.aniosAntiguedad * 2000;
        return total;
    }
}
