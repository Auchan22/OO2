package ar.edu.unlp.info.oo1.ejercicio_13;

public class SubteWay {
	private SandwichBuilder constructor;
	
	public SubteWay(SandwichBuilder constructor) {
		this.constructor = constructor;	
	}

	public void hacerSandwich() {
		this.constructor.reset();
		this.constructor.agregarPan();
		this.constructor.agregarAderezo();
		this.constructor.agregarPrincipal();
		this.constructor.agregarAdicional();
	}
	
	public void cambiarConstructor(SandwichBuilder constructor) {
		this.constructor = constructor;	
	}
}
