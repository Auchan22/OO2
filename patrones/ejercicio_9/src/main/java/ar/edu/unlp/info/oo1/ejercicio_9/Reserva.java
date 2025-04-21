package ar.edu.unlp.info.oo1.ejercicio_9;

import java.time.LocalDate;

public class Reserva {
	private int cantidadDias;
	private LocalDate fecha;
	private Usuario conductor;
	private AutoEnAlquiler auto;
	
	public Reserva(int cantidadDias, Usuario conductor, AutoEnAlquiler auto) {
		this.cantidadDias = cantidadDias;
		this.fecha = LocalDate.now();
		this.conductor = conductor;
		this.auto = auto;
	}

	public double montoAPagar() {
		return this.cantidadDias * this.auto.getPrecioPorDia();
	}
	
	public double montoAReembolsar(LocalDate fechaFin) {
		return this.auto.calcularMontoReembolso(this.fecha, fechaFin, this.montoAPagar());
	}
}
