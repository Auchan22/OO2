package ar.edu.unlp.info.oo1.ejercicio_13;

public class ConcreteVegetarianoBuilder extends SandwichBuilder {

	@Override
	public void agregarPan() {
		this.obtenerSandwich().setPan(120);
	}

	@Override
	public void agregarAderezo() {
		this.obtenerSandwich().setAderezo(0);
	}

	@Override
	public void agregarPrincipal() {
		this.obtenerSandwich().setPrincipal(200);
	}

	@Override
	public void agregarAdicional() {
		this.obtenerSandwich().setAdicional(100);
	}
}
