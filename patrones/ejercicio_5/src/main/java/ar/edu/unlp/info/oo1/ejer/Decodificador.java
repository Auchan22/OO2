package ar.edu.unlp.info.oo1.ejer;

import java.util.ArrayList;
import java.util.List;

public class Decodificador {
	private List<Pelicula> grillaPeliculas;
	private List<Pelicula> peliculasReproducidas;
	private Strategy strategy;
	
	public Decodificador() {
		this.grillaPeliculas = new ArrayList<Pelicula>();
		this.peliculasReproducidas = new ArrayList<Pelicula>();
	}
	
	public void sugerir() {
		this.strategy.sugerir(grillaPeliculas, peliculasReproducidas);
	};
	
	public void imprimirGrilla() {
		this.grillaPeliculas.stream().forEach(p -> {
			System.out.println("- " + p.toString());
		});
	}
	
	public void reproducirPelicula(Pelicula p) throws Exception {
		if(this.grillaPeliculas.contains(p)) {
			if(!this.peliculasReproducidas.contains(p)) {
				this.peliculasReproducidas.add(p);
			}
		}else {
			throw new Exception("La película deseada no existe en el sistema.");
		}
	}
	
	public Strategy getStrategy() {
		return this.strategy;
	}
	
	public void setEstrategy(Strategy s) {
		this.strategy = s;
	}
}
