package ar.edu.unlp.info.oo1.ejercicio_13;

public class ConcreteSinTACCBuilder extends SandwichBuilder {

	@Override
	public void agregarPan() {
		this.obtenerSandwich().setPan(150);
	}

	@Override
	public void agregarAderezo() {
		this.obtenerSandwich().setAderezo(18);
	}

	@Override
	public void agregarPrincipal() {
		this.obtenerSandwich().setPrincipal(250);
	}

	@Override
	public void agregarAdicional() {
		this.obtenerSandwich().setAdicional(200);
	}

}
