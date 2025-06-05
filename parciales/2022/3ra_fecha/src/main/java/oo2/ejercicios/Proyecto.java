package oo2.ejercicios;

import java.time.Duration;
import java.time.LocalDate;

public class Proyecto {
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String objetivo;
    private int cantIntegrantes;
    private double montoDia;
    private double margenGanancia;
    private Etapa etapa;

    public Proyecto(LocalDate fechaInicio, LocalDate fechaFin, String nombre, String objetivo, int cantIntegrantes, double montoDia) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombre = nombre;
        this.objetivo = objetivo;
        this.cantIntegrantes = cantIntegrantes;
        this.margenGanancia = 0.07;
        this.montoDia = montoDia;
        this.etapa = new EnConstruccion(this);
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public int getCantIntegrantes() {
        return cantIntegrantes;
    }

    public double getMargenGanancia() {
        return margenGanancia;
    }

    public void setMargenGanancia(double margenGanancia) {
        this.margenGanancia = margenGanancia;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public double getMontoDia() {
        return montoDia;
    }

    public void establecerEtapa(Etapa e) {
        this.etapa = e;
    }

    private int calcularDuracionProyecto(){
        return (int)Duration.between(fechaInicio, fechaFin).toDays();
    }

    public double calcularCosto(){
        return this.cantIntegrantes*this.montoDia*this.calcularDuracionProyecto();
    }

    public double calcularPrecio(){
        return this.calcularCosto() + (this.calcularCosto()*this.margenGanancia);
    }

    public void cancelarProyecto(){
        this.setObjetivo(this.getObjetivo() + "(Cancelado)");
        this.etapa.cancelar();
    }

    public void modificarMargenGanancia(double margenGanancia){
        this.etapa.modificarMargenGanancia(margenGanancia);
    }

    public void aprobarEtapa(){
        this.etapa.aprobarEtapa();
    }
}
