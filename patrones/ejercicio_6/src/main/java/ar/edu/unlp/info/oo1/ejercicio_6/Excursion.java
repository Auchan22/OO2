package ar.edu.unlp.info.oo1.ejercicio_6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Excursion {
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String puntoEncuentro;
	private double costo;
	private int cupoMin;
	private int cupoMax;
	private List<Usuario> inscriptos;
	private List<Usuario> espera;
	private State estado;
	
	public Excursion(String nombre, LocalDate fechaInicio, LocalDate fechaFin, String puntoEncuentro, double costo,
			int cupoMin, int cupoMax) {
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.puntoEncuentro = puntoEncuentro;
		this.costo = costo;
		this.cupoMin = cupoMin;
		this.cupoMax = cupoMax;
		this.inscriptos = new ArrayList<Usuario>();
		this.espera = new ArrayList<Usuario>();
		this.estado = new Provisoria(this);
	}

	public void setEstado(State e) {
		this.estado = e;
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

	public int getCupoMin() {
		return cupoMin;
	}

	public void setCupoMin(int cupoMin) {
		this.cupoMin = cupoMin;
	}

	public int getCupoMax() {
		return cupoMax;
	}

	public void setCupoMax(int cupoMax) {
		this.cupoMax = cupoMax;
	}

	public List<Usuario> getInscriptos() {
		return inscriptos;
	}

	public void setInscriptos(List<Usuario> inscriptos) {
		this.inscriptos = inscriptos;
	}

	public List<Usuario> getEspera() {
		return espera;
	}

	public void setEspera(List<Usuario> espera) {
		this.espera = espera;
	}
	
	public int cantUsuariosRestantesMaximo() {
		return this.cupoMax - this.inscriptos.size();
	}
	
	public int cantUsuariosRestantesMinimo() {
		if(this.inscriptos.size() <= this.cupoMin) {
			return this.cupoMin - this.inscriptos.size();
		}
		return 0;
	}
	
	public boolean alcanzoMax() {
		return this.inscriptos.size() == this.cupoMax;
	}
	
	public boolean alcanzoMin() {
		return this.inscriptos.size() == this.cupoMin;
	}
	
	public void agregarUsuario(Usuario u) {
		this.estado.inscribir(u);
	}
	
	public String obtenerInformacion() {
		return this.estado.obtenerInformacion();
	}
}
