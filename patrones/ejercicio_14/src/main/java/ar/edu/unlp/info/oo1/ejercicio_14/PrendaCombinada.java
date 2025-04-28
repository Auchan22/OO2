package ar.edu.unlp.info.oo1.ejercicio_14;

import java.util.ArrayList;
import java.util.List;

public class PrendaCombinada extends PrendaBase{
    private List<Prenda> prendas;

    public PrendaCombinada() {
        super(0.5);
        this.prendas = new ArrayList<Prenda>();
    }

    public void agregarPrenda(Prenda prenda){
        if(!this.prendas.contains(prenda)){
            this.prendas.add(prenda);
        }
    }

    public void removerPrenda(Prenda prenda){
        if(this.prendas.contains(prenda)){
            this.prendas.remove(prenda);
        }
    }

    public List<Prenda> getPrendas() {
        return new ArrayList<>(this.prendas);
    }

    @Override
    public double calcularValor() {
        return this.prendas.stream().mapToDouble(Prenda::calcularValor).sum();
    }
}
