package ar.edu.unlp.info.oo1.ejercicio_10;

public class FeistelCipherAdapter implements AlgoritmoStrategy {
	
	private FeistelCipher adaptee;
	
	public FeistelCipherAdapter(String key) {
		this.adaptee = new FeistelCipher(key);
	}

	@Override
	public String cifrar(String mensaje, String key) {
		return adaptee.encode(mensaje);
	}

	@Override
	public String descifrar(String mensaje, String key) {
		return adaptee.encode(mensaje);
	}

}
