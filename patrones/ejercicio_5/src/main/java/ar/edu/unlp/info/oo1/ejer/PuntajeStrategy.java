package ar.edu.unlp.info.oo1.ejer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PuntajeStrategy implements Strategy {

	@Override
    public List<Pelicula> sugerir(List<Pelicula> grilla, List<Pelicula> peliculasReproducidas) {
        List<Pelicula> reproducidas = peliculasReproducidas;

        return grilla.stream()
                .filter(p -> !reproducidas.contains(p))
                .sorted(Comparator
                        .comparingDouble((Pelicula p) -> p.getPuntaje()).reversed()
                        .thenComparing((Pelicula p) -> p.getAnio_estreno(), Comparator.reverseOrder())
                )
                .limit(3)
                .collect(Collectors.toList());
    }


}
