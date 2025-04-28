package ar.edu.unlp.info.oo1.ejercicio_14;

import java.time.LocalDate;

public class Automovil implements PrendaInterface {
	private LocalDate modelo;
	private double kilometraje;
	private double costo;
	
	public Automovil(LocalDate modelo, double kilometraje, double costo) {
		this.modelo = modelo;
		this.kilometraje = kilometraje;
		this.costo = costo;
	}

	public LocalDate getModelo() {
		return modelo;
	}

	public void setModelo(LocalDate modelo) {
		this.modelo = modelo;
	}

	public double getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(double kilometraje) {
		this.kilometraje = kilometraje;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	@Override
	public double calcularValor() {
		return 0;
	}
	
	
}
