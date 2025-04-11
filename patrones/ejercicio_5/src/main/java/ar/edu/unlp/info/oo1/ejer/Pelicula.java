package ar.edu.unlp.info.oo1.ejer;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
	private String titulo;
	private int anio_estreno;
	private double puntaje;
	private List<Pelicula> peliculasSimilares;
	
	
	public Pelicula(String titulo, int anio_estreno, double puntaje) {
		this.titulo = titulo;
		this.anio_estreno = anio_estreno;
		this.puntaje = puntaje;
		this.peliculasSimilares = new ArrayList<Pelicula>();
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAnio_estreno() {
		return anio_estreno;
	}
	public void setAnio_estreno(int anio_estreno) {
		this.anio_estreno = anio_estreno;
	}
	public double getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(double puntaje) {
		this.puntaje = puntaje;
	}
	public List<Pelicula> getPeliculasSimilares() {
		return new ArrayList<Pelicula>(peliculasSimilares);
	}
	public void setPeliculasSimilares(List<Pelicula> peliculasSimilares) {
		this.peliculasSimilares = peliculasSimilares;
	}
	
	
}
