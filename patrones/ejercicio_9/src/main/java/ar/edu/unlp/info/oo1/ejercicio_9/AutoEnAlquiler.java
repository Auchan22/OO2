package ar.edu.unlp.info.oo1.ejercicio_9;

import java.time.LocalDate;

public class AutoEnAlquiler {
	private double precioPorDia;
	private int cantidadPlazas;
	private String marca;
	private PoliticaCancelacion politica;
	
	public AutoEnAlquiler(double precioPorDia, int cantidadPlazas, String marca, PoliticaCancelacion politica) {
		this.precioPorDia = precioPorDia;
		this.cantidadPlazas = cantidadPlazas;
		this.marca = marca;
		this.politica = politica;
	}
	
	public void setPoliticaCancelacion(PoliticaCancelacion politica) {
		this.politica = politica;
	}
	
	public double calcularMontoReembolso(LocalDate fechaInicio, LocalDate fechaFin, double montoReembolso) {
		return this.politica.calcularReembolso(fechaInicio, fechaFin, montoReembolso);
	}
	
	public double getPrecioPorDia() {
		return precioPorDia;
	}
	public int getCantidadPlazas() {
		return cantidadPlazas;
	}
	public String getMarca() {
		return marca;
	}
	
	
}
