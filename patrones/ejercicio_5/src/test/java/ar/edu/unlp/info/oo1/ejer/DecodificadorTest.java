package ar.edu.unlp.info.oo1.ejer;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DecodificadorTest {
	private Decodificador decodificador;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.decodificador = new Decodificador();
		
		Pelicula thor = new Pelicula("Thor", 7.9, 2007);
		Pelicula capitanAmerica = new Pelicula("Capitan America", 7.8, 2016);
		Pelicula ironMan = new Pelicula("Iron man", 7.9, 2010);
		Pelicula dunkirk = new Pelicula("Dunkirk", 7.9, 2017);
		Pelicula rocky = new Pelicula("Rocky", 8.1, 1976);
		Pelicula rambo = new Pelicula("Rambo", 7.8, 1979);

		// Establecer similaridad (relación recíproca)
		thor.agregarSimilar(capitanAmerica);
		thor.agregarSimilar(ironMan);
		capitanAmerica.agregarSimilar(ironMan);
		rocky.agregarSimilar(rambo);

		List<Pelicula> grilla = Arrays.asList(
		    thor,
		    capitanAmerica,
		    ironMan,
		    dunkirk,
		    rocky,
		    rambo
		);
		grilla.forEach(p -> decodificador.agegarPelicula(p));
		decodificador.reproducirPelicula(thor);
		decodificador.reproducirPelicula(rocky);
	}
	
	@Test
	public void testDecodificador() throws IllegalAccessException {
		System.out.println("Sugerencia similaridad");
		decodificador.setEstrategy(new SimilaridadStrategy());
		decodificador.sugerir();
		System.out.println("Sugerencia puntaje");
		decodificador.setEstrategy(new PuntajeStrategy());
		decodificador.sugerir();
	}
}
