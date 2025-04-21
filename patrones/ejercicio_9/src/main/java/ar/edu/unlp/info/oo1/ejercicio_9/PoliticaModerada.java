package ar.edu.unlp.info.oo1.ejercicio_9;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PoliticaModerada implements PoliticaCancelacion {

	@Override
	public double calcularReembolso(LocalDate fechaInicio, LocalDate fechaFin, double montoTotal) {
		long diasDiferencia = ChronoUnit.DAYS.between(fechaFin, fechaInicio);
        if (diasDiferencia >= 7) {
            return montoTotal;
        } else if (diasDiferencia >= 2) {
            return montoTotal * 0.5;
        } else {
            return 0;
        }
	}

}
