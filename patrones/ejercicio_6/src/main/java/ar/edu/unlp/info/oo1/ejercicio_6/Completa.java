package ar.edu.unlp.info.oo1.ejercicio_6;

import java.time.format.DateTimeFormatter;

public class Completa extends State {
	public Completa(Excursion e) {
		super(e);
	}

	@Override
	public void inscribir(Usuario unUsuario) {
		this.excursion.getEspera().add(unUsuario);
	}

	@Override
	public String obtenerInformacion() {
		return super.obtenerInformacion();
	}
}
