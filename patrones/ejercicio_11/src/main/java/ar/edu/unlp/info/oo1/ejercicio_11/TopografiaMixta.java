package ar.edu.unlp.info.oo1.ejercicio_11;

import java.util.ArrayList;
import java.util.List;

public class TopografiaMixta extends Topografia {
	private List<Topografia> topografias;
	
	public TopografiaMixta(Topografia componente1, Topografia componente2, 
			Topografia componente3, Topografia componente4) {
			this.topografias = new ArrayList<>();
			this.topografias.add(componente1);
			this.topografias.add(componente2);
			this.topografias.add(componente3);
			this.topografias.add(componente4);
		}
	
	@Override
	public List<Topografia> getTopografia (){
		return this.topografias;
	}

	@Override
	public double getProporcionAgua() {
		return (this.topografias.stream().mapToDouble(componente -> componente.getProporcionAgua()).sum())/this.topografias.size();
	}

	@Override
	public boolean isEquals(Topografia topografia) {
		return this.topografias.equals(topografia.getTopografia());
	}
}
