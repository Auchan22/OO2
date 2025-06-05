package oo2.ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Compleja implements Tarea{

    private List<Tarea> tareas;
    private String nombre;

    public Compleja(String nombre){
        this.nombre = nombre;
        this.tareas = new ArrayList<Tarea>();
    }

    public void agregarTarea(Tarea tarea){
        this.tareas.add(tarea);
    }

    public List<Tarea> getTareas(){
        return new ArrayList<>(this.tareas);
    }

    @Override
    public void iniciarTarea() {
        this.tareas.forEach(t -> t.iniciarTarea());
    }

    @Override
    public void completarTarea() {
        this.tareas.forEach(t -> t.completarTarea());
    }

    @Override
    public double calcularEstimacion() {
        return this.tareas.stream().mapToDouble(t -> t.calcularEstimacion()).sum();
    }

    @Override
    public long tiempoUtilizado() {
        return this.tareas.stream().mapToLong(t -> t.tiempoUtilizado()).sum();
    }

    public double calcularAvanceTarea(){
        return this.tiempoUtilizado()/this.calcularEstimacion();
    }
}
