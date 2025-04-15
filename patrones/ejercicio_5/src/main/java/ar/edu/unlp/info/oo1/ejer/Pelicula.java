package ar.edu.unlp.info.oo1.ejer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pelicula {
	private String titulo;
	private int anio_estreno;
	private double puntaje;
	private Set<Pelicula> peliculasSimilares;
	
	
	public Pelicula(String titulo, double puntaje, int anio_estreno) {
		this.titulo = titulo;
		this.anio_estreno = anio_estreno;
		this.puntaje = puntaje;
		this.peliculasSimilares = new HashSet<Pelicula>();
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
	public void setPeliculasSimilares(Set<Pelicula> peliculasSimilares) {
		this.peliculasSimilares = peliculasSimilares;
	}
	
    public void agregarSimilar(Pelicula otra) {
        this.peliculasSimilares.add(otra);
        otra.peliculasSimilares.add(this); // relación recíproca
    }
	
    @Override
    public String toString() {
        return titulo + " (" + anio_estreno + ")";
    }
	
	
}
