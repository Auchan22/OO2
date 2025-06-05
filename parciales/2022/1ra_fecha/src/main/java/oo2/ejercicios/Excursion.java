package oo2.ejercicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Excursion {
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String puntoEncuentro;
    private double costo;
    private int cupoMinimo;
    private int cupoMaximo;
    private EstadoExcursion estado;
    private List<Usuario> inscriptos;
    private List<Usuario> espera;

    public Excursion(String nombre, LocalDate fechaInicio, LocalDate fechaFin, String puntoEncuentro, double costo, int cupoMinimo, int cupoMaximo) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.puntoEncuentro = puntoEncuentro;
        this.costo = costo;
        this.cupoMinimo = cupoMinimo;
        this.cupoMaximo = cupoMaximo;
        this.inscriptos = new ArrayList<Usuario>();
        this.espera = new ArrayList<Usuario>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getPuntoEncuentro() {
        return puntoEncuentro;
    }

    public void setPuntoEncuentro(String puntoEncuentro) {
        this.puntoEncuentro = puntoEncuentro;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCupoActual() {
        return this.inscriptos.size();
    }

    public int getCupoMinimo() {
        return cupoMinimo;
    }

    public void setCupoMinimo(int cupoMinimo) {
        this.cupoMinimo = cupoMinimo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public EstadoExcursion getEstado() {
        return estado;
    }

    public void setEstado(EstadoExcursion estado) {
        this.estado = estado;
    }

    @Override
    public String toString(){
        return "Nombre: "+this.getNombre()+"\n"+
                "Costo: "+this.getCosto()+"\n"+
                "Fecha Inicio: "+this.getFechaInicio().format(DateTimeFormatter.BASIC_ISO_DATE)+"\n"+
                "Fecha Fin: "+this.getFechaFin().format(DateTimeFormatter.BASIC_ISO_DATE)+"\n"+
                "Punto de Encuentro: "+this.getPuntoEncuentro()+"\n";
    }

    public String renderMailsUsuarios(){
        return this.inscriptos.stream().map(u -> "  - "+u.getEmail()).collect(Collectors.joining("\n"));
    }

    public int getCantidadFaltantesMinimo(){
        return this.getCupoActual() < this.cupoMinimo ? this.getCupoActual()-this.cupoMinimo : 0;
    }

    public int getCantidadFaltantesMaximo(){
        return this.getCupoActual() < this.cupoMaximo ? this.getCupoActual()-this.getCupoMaximo() : 0;
    }

    public boolean cumpleCupoMinimo(){
        return getCantidadFaltantesMinimo()==0;
    }

    public boolean cumpleCupoMaximo(){
        return getCantidadFaltantesMaximo()==0;
    }

    public void inscribir(Usuario usuario){
        this.estado.inscribirUsuario(usuario);
    }

    public String getInformacion(){
        return this.estado.mostrarExcursion();
    }

    public void inscribirUsuario(Usuario usuario) {
        this.inscriptos.add(usuario);
    }

    public void agregarEnEspera(Usuario usuario) {
        this.espera.add(usuario);
    }
}
