package ar.edu.unlp.info.oo1.ejercicio_9;

import java.time.LocalDate;

public class PoliticaEstricta implements PoliticaCancelacion {

	@Override
	public double calcularReembolso(LocalDate fechaInicio, LocalDate fechaFin, double montoTotal) {
		return 0;
	}

}
