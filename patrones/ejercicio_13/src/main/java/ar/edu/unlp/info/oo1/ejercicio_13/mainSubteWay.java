package ar.edu.unlp.info.oo1.ejercicio_13;

public class mainSubteWay {
	public static void main(String[] args) {
		ConcreteClasicoBuilder cb = new ConcreteClasicoBuilder();
		SubteWay sb = new SubteWay(cb);
		
		sb.hacerSandwich();
		
		System.out.println(cb.obtenerSandwich().calcularPrecio());
	}
}
