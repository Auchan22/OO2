package ar.edu.unlp.info.oo1.ejercicio_6;

import java.util.stream.Collectors;

public class Definitiva extends State {

	public Definitiva(Excursion e) {
		super(e);
	}
	
	@Override
	public void inscribir(Usuario unUsuario) {
		this.excursion.getInscriptos().add(unUsuario);
		if(this.excursion.alcanzoMax()) {
			this.excursion.setEstado(new Completa(this.excursion));
		}
	}
	
	@Override
	public String obtenerInformacion() {
		StringBuilder mails = new StringBuilder();
		this.excursion.getInscriptos().forEach(i -> mails.append("  * ").append(i.getEmail()));
		String resultado = mails.toString();
		return super.obtenerInformacion() + 
				"\n - Mails de inscriptos: \n "+ resultado +
				"\n - Cantidad de usuarios restantes para alcanzar cupo máximo: "+this.excursion.cantUsuariosRestantesMaximo(); 
	}
}
