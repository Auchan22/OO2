package oo2.ejercicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Proyecto> proyectos;

    public Empresa() {
        this.proyectos = new ArrayList<Proyecto>();
    }

    public void crearProyecto(String nombre, LocalDate fechaInicio, LocalDate fechaFin, String objetivo, int cantIntegrantes, double montoDia) {
        Proyecto p = new Proyecto(fechaInicio, fechaFin, nombre, objetivo, cantIntegrantes, montoDia);
        this.proyectos.add(p);
    }

    public void aprobarEtapa(Proyecto p){
        if(this.proyectos.contains(p)){
            p.aprobarEtapa();
        }else {
            throw new RuntimeException("No se puede aprobar el proyecto, no esta incluido en la empresa.");
        }
    }

    public double obtenerCosto(Proyecto p){
        if(this.proyectos.contains(p)){
            return p.calcularCosto();
        }else {
            throw new RuntimeException("No se puede aprobar el proyecto, no esta incluido en la empresa.");
        }
    }

    public double obtenerPrecio(Proyecto p){
        if(this.proyectos.contains(p)){
            return p.calcularPrecio();
        }else {
            throw new RuntimeException("No se puede aprobar el proyecto, no esta incluido en la empresa.");
        }
    }

    public void modificarMargenGanancia(Proyecto p, double margenGanancia){
        if(this.proyectos.contains(p)){
            p.modificarMargenGanancia(margenGanancia);
        }else {
            throw new RuntimeException("No se puede aprobar el proyecto, no esta incluido en la empresa.");
        }
    }

    public void cancelarProyecto(Proyecto p){
        if(this.proyectos.contains(p)){
            p.cancelarProyecto();
        }else {
            throw new RuntimeException("No se puede aprobar el proyecto, no esta incluido en la empresa.");
        }
    }
}
