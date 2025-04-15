package ar.edu.unlp.info.oo1.ejercicio_6;

import java.time.format.DateTimeFormatter;

public abstract class State {
	protected Excursion excursion;
	
	public State(Excursion e) {
		this.excursion = e;
	}
	
	public Excursion getExcursion() {
		return this.excursion;
	}
	
	public abstract void inscribir(Usuario unUsuario);
	public String obtenerInformacion() {
		return " - Nombre: " + this.excursion.getNombre() + 
				"\n - Costo: $"+this.excursion.getCosto() + 
				"\n - Fechas: "+this.excursion.getFechaInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +" - " +  this.excursion.getFechaFin().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + 
				"\n - Punto de encuentro: "+this.excursion.getPuntoEncuentro(); 
	};

	
}
