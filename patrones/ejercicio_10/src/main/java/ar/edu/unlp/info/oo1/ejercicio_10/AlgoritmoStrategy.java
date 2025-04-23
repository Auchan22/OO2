package ar.edu.unlp.info.oo1.ejercicio_10;

public interface AlgoritmoStrategy {
	public String cifrar(String mensaje, String key);
	public String descifrar(String mensaje, String key);
}
