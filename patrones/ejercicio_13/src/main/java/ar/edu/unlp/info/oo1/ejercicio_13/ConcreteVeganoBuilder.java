package ar.edu.unlp.info.oo1.ejercicio_13;

public class ConcreteVeganoBuilder extends SandwichBuilder {

	@Override
	public void agregarPan() {
		this.obtenerSandwich().setPan(100);
	}

	@Override
	public void agregarAderezo() {
		this.obtenerSandwich().setAderezo(20);
	}

	@Override
	public void agregarPrincipal() {
		this.obtenerSandwich().setPrincipal(500);
	}

	@Override
	public void agregarAdicional() {
		this.obtenerSandwich().setAdicional(0);
	}

}
