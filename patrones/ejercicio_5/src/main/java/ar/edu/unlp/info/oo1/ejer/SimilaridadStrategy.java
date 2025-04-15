package ar.edu.unlp.info.oo1.ejer;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SimilaridadStrategy implements Strategy {

	@Override
    public List<Pelicula> sugerir(List<Pelicula> grilla, List<Pelicula> peliculasReproducidas) {
        List<Pelicula> reproducidas = peliculasReproducidas;

        Set<Pelicula> similares = new HashSet<>();
        for (Pelicula p : reproducidas) {
            similares.addAll(p.getPeliculasSimilares());
        }

        similares.removeAll(reproducidas); // No sugerir las que ya se vieron

        return similares.stream()
                .sorted(Comparator.comparing((Pelicula p) -> p.getAnio_estreno()).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

}
