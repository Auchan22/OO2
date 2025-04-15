package ar.edu.unlp.info.oo1.ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class Calculadora {
	
	private List<Double> operandos = new ArrayList<Double>();
	private boolean hasError = false;
	private String operador = "";
	
    /**
 	* Devuelve el resultado actual de la operación realizada.
	* Si no se ha realizado ninguna operación, devuelve el valor acumulado.
	* Si la calculadora se encuentra en error, devuelve “error”
     */
    public String getResultado() {
    	if(this.hasError || this.operandos.size() < 2) {
    		return "Error";
    	}else {
    		double operador1 = this.operandos.get(0);
    		double operador2 = this.operandos.get(1);
    		double resultado = 0;
    		switch (operador) {
			case "+":
				resultado = operador1 + operador2; 
				break;
			
			case "-":
				resultado = operador1 - operador2;
				break;
				
			case "*":
				resultado = operador1 * operador2;
				break;
				
			case "/":
				if(operador2 == 0) {
					this.hasError = true;
					return "Error";
				}
				resultado = operador1 / operador2;
				break;
			}
    		
    		this.operandos.clear();
    		this.operandos.add(resultado);
    		this.operador = "";
    		
    		return ""+resultado;
    	}
    }


    /**
     * Pone en cero el valor acumulado y reinicia la calculadora
     */
    public void borrar() {
    	this.hasError = false;
    	this.operador = "";
    	this.operandos.clear();
    }


    /**
     * Asigna un valor para operar. 
     * si hay una operación en curso, el valor será utilizado en la operación
     */
    public void setValor(double unValor) {
    	if(this.operandos.size() == 0 || this.operador != null) {
    		this.operandos.add(unValor);
    	}else {
    		this.hasError = true;
    	}
    }


     /**
     * Indica que la calculadora debe esperar un nuevo valor. 
	 * Si a continuación se le envía el mensaje setValor(), la calculadora sumará el valor recibido como parámetro, al valor actual y guardará el resultado 
     */
    public void mas() {
    	if(this.operandos.size() == 1) {
    		this.operador = "+";
    	}else {
    		this.hasError = true;
    	}
    }
    
    public void menos() {
    	if(this.operandos.size() == 1) {
    		this.operador = "-";
    	}else {
    		this.hasError = true;
    	}
    }
    
    public void por() {
    	if(this.operandos.size() == 1) {
    		this.operador = "*";
    	}else {
    		this.hasError = true;
    	}
    }
    
    public void dividido() {
    	if(this.operandos.size() == 1) {
    		this.operador = "/";
    	}else {
    		this.hasError = true;
    	}
    }
}
