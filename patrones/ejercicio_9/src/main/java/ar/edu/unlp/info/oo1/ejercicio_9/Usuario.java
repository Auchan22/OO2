package ar.edu.unlp.info.oo1.ejercicio_9;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private List<AutoEnAlquiler> autosEnAlquiler;
	
	public Usuario(String nombre) {
		this.nombre = nombre;
		this.autosEnAlquiler = new ArrayList<AutoEnAlquiler>();
	}
	
	public void agregarAuto(AutoEnAlquiler auto) {
		this.autosEnAlquiler.add(auto);
	}
	
	
}
