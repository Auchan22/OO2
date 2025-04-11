package ar.edu.unlp.info.oo1.ejer;

import java.util.List;

public interface Strategy {
	public List<Pelicula>  sugerir(List<Pelicula> grillaPeliculas, List<Pelicula> peliculasReproducidas);
}
