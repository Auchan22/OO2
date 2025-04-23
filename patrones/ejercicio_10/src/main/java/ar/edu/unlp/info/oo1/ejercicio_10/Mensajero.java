package ar.edu.unlp.info.oo1.ejercicio_10;

import javax.management.InvalidAttributeValueException;

public class Mensajero {
	
	private AlgoritmoStrategy strategy;
	private String clave;

	
	public void setStrategy(AlgoritmoStrategy s) {
		this.strategy = s;
	}
	
	public String enviar(String mensaje) throws InvalidAttributeValueException {
		if(this.strategy == null) {
			throw new InvalidAttributeValueException("No se definio algoritmo de encriptación");
		}
		
		return this.strategy.cifrar(mensaje, this.clave);
	}
	
	public String recibir(String mensaje) throws InvalidAttributeValueException {
		if(this.strategy == null) {
			throw new InvalidAttributeValueException("No se definio algoritmo de encriptación");
		}
		
		return this.strategy.descifrar(mensaje, this.clave);
	}

}
