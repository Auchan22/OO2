package ar.edu.unlp.info.oo1.ejercicio_9;

import java.time.LocalDate;

public interface PoliticaCancelacion {
	public double calcularReembolso(LocalDate fechaInicio, LocalDate fechaFin, double montoTotal);
}
