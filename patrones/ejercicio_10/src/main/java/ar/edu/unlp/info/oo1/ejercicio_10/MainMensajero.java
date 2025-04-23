package ar.edu.unlp.info.oo1.ejercicio_10;

import javax.management.InvalidAttributeValueException;

public class MainMensajero {
	public static void main(String[] args) throws InvalidAttributeValueException {
		Mensajero mensajero = new Mensajero();
		
		mensajero.setStrategy(new FeistelCipherAdapter("123132asdasdefgg3#"));
		System.out.println(mensajero.enviar("Hola mundo"));
		
		mensajero.setStrategy(new RC4Adapter());
		System.out.println(mensajero.enviar("Hola mundo"));
	}
}
