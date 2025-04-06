package ar.edu.unlp.info.oo2.ejercicio_2;

public abstract class Empleado {
	protected int cantHijos;
	protected boolean casado;
	protected int cantHoras;
	protected int aniosAntiguedad;
	
	protected abstract double sueldoBasico();
	protected abstract double sueldoAdicional();
	protected double obtenerDescuento() {
		return this.sueldoBasico() * 0.13 + this.sueldoAdicional() * 0.5; 
	}
	
}
