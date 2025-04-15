package ar.edu.unlp.info.oo1.ejercicio_6;

public class Provisoria extends State{
	
	public Provisoria(Excursion e) {
		super(e);
	}
	
	@Override
	public void inscribir(Usuario unUsuario) {
		this.excursion.getInscriptos().add(unUsuario);
		if(this.excursion.alcanzoMin()) {
			this.excursion.setEstado(new Definitiva(this.excursion));
		}
	}
	
	@Override
	public String obtenerInformacion() {
		return super.obtenerInformacion() +
				"\n - Cantidad de usuarios restantes para alcanzar cupo mínimo: "+this.excursion.cantUsuariosRestantesMinimo(); 
	}

}
