package oo2.ejercicio2;

import java.time.LocalDate;

public class Presupuesto {
    private String nombre;
    private LocalDate fecha;
    private Equipo equipo;

    public Presupuesto(String nombre, Equipo equipo) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.fecha = LocalDate.now();
    }
}
