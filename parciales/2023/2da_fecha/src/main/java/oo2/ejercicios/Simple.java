package oo2.ejercicios;

import java.time.LocalDate;

public class Simple implements Tarea {
    private String nombre;
    private int duracionHoras;
    private long momentoInicio;
    private long momentoFin;
    private EstadoTarea estado;

    public Simple(String nombre, int duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
        this.estado = new Creada(this);
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    @Override
    public void iniciarTarea() {
        this.estado.iniciarTarea();
    }

    @Override
    public void completarTarea() {
        this.estado.completarTarea();
    }

    @Override
    public double calcularEstimacion() {
        return this.duracionHoras;
    }

    @Override
    public long tiempoUtilizado() {
        return this.estado.calcularTiempoUtilizado();
    }

    public long getMomentoFin() {
        return momentoFin;
    }

    public long getMomentoInicio() {
        return momentoInicio;
    }

    public void setMomentoInicio(long momentoInicio) {
        this.momentoInicio = momentoInicio;
    }

    public void setMomentoFin(long momentoFin) {
        this.momentoFin = momentoFin;
    }

    public void cambiarEstado(EstadoTarea estado) {
        this.estado = estado;
    }
}
