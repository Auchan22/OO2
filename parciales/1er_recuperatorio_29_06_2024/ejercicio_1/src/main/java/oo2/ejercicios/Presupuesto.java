package oo2.ejercicios;

import java.time.LocalDate;

public class Presupuesto extends Equipo {
    private String nombre;
    private LocalDate fecha;
    private Equipo equipo;

    public Presupuesto() {
        this.equipo = new Equipo();
        this.fecha = LocalDate.now();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void definirEquipo(Equipo e){
        this.equipo = e;
    }

    public Equipo obtenerEquipo(){
        return this.equipo;
    }
}
