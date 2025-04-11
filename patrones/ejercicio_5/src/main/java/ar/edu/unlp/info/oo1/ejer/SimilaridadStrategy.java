package ar.edu.unlp.info.oo1.ejer;

import java.util.List;
import java.util.stream.Collectors;

public class SimilaridadStrategy implements Strategy {

	@Override
	public List<Pelicula> sugerir(List<Pelicula> grillaPeliculas, List<Pelicula> peliculasReproducidas) {
		return peliculasReproducidas.stream().map(p -> p.getPeliculasSimilares()).collect(Collectors.toList());
	}

}
