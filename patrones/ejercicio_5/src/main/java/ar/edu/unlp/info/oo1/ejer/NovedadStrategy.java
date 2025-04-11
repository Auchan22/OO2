package ar.edu.unlp.info.oo1.ejer;

import java.util.List;
import java.util.stream.Collectors;

public class NovedadStrategy implements Strategy {

	@Override
	public List<Pelicula> sugerir(List<Pelicula> grillaPeliculas, List<Pelicula> peliculasReproducidas) {
	    return grillaPeliculas.stream()
	            .filter(p -> !peliculasReproducidas.contains(p))
	            .sorted((p1, p2) -> Integer.compare(p2.getAnio_estreno(), p1.getAnio_estreno())) // más nuevas primero
	            .limit(3)
	            .collect(Collectors.toList());
	}
}
