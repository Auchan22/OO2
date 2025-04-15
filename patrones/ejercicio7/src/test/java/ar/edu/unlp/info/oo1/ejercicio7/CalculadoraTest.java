package ar.edu.unlp.info.oo1.ejercicio7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
	private Calculadora calculadora;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.calculadora = new Calculadora();
	}
	
	@Test
	public void testCalculo() {
		calculadora.setValor(5); // Establece el valor inicial 
		calculadora.mas(); // Prepara para sumar 
		calculadora.setValor(3); // Suma 3 al valor acumulado 
		System.out.println(calculadora.getResultado()); // Imprimirá "8.0"
		calculadora.por();
		calculadora.setValor(2);
		assertEquals(calculadora.getResultado(), "16.0");
	}
	
	@Test
	public void testCalculoErrorOperando2() {
		calculadora.setValor(5); 
		calculadora.mas();
		assertEquals(calculadora.getResultado(), "Error");
	}

	@Test
	public void testCalculoErrorDividirPorCero() {
		calculadora.setValor(5); 
		calculadora.dividido();
		calculadora.setValor(0); 
		assertEquals(calculadora.getResultado(), "Error");
	}
	
	@Test
	public void testCalculoErrorEsperaValor() {
		calculadora.setValor(5); 
		calculadora.mas();
		calculadora.menos(); 
		assertEquals(calculadora.getResultado(), "Error");
	}
	
	@Test
	public void testCalculoBorrarError() {
		calculadora.setValor(5); 
		calculadora.mas();
		calculadora.menos(); 
		assertEquals(calculadora.getResultado(), "Error");
		calculadora.borrar();
		calculadora.setValor(5); 
		calculadora.mas();
		calculadora.setValor(2); 
		assertEquals(calculadora.getResultado(), "7.0");
	}
}