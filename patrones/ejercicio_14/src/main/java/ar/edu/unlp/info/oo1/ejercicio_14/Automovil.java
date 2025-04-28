package ar.edu.unlp.info.oo1.ejercicio_14;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Automovil extends PrendaBase {
	private LocalDate modelo;
	private double kilometraje;
	private double costo;
	
	public Automovil(LocalDate modelo, double kilometraje, double costo) {
		super(0.5);
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
		long antiguedadAnios = ChronoUnit.YEARS.between(this.modelo, LocalDate.now());
		// Asegurarse de que la antigüedad no sea negativa (por si la fecha de fabricación es en el futuro)
		antiguedadAnios = Math.max(0, antiguedadAnios);
		double porcentajeDepreciacion = (double) antiguedadAnios * 0.10; // 10% por año
		porcentajeDepreciacion = Math.min(1.0, porcentajeDepreciacion);
		double factorDepreciacion = 1.0 - porcentajeDepreciacion;
		return costo * factorDepreciacion;
	}
	
	
}
