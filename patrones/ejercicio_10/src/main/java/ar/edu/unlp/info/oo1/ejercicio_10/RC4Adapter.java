package ar.edu.unlp.info.oo1.ejercicio_10;

public class RC4Adapter implements AlgoritmoStrategy {
	
	private RC4 adaptee;
	
	public RC4Adapter() {
		this.adaptee = new RC4();
	}

	@Override
	public String cifrar(String mensaje, String key) {
		return this.adaptee.encriptar(mensaje, key);
	}

	@Override
	public String descifrar(String mensaje, String key) {
		return this.adaptee.desencriptar(mensaje, key);
	}

}
