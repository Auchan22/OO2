package oo2.ejercicios;

import java.time.format.DateTimeFormatter;

public abstract class EstadoExcursion {
    private Excursion excursion;

    public EstadoExcursion(Excursion excursion) {
        this.excursion = excursion;
    }

    public String mostrarExcursion(){
        return this.excursion.toString()+
                this.informacionAdicional();
    }

    public Excursion getExcursion() {
        return excursion;
    }

    public abstract String informacionAdicional();

    public abstract void inscribirUsuario(Usuario usuario);
}
