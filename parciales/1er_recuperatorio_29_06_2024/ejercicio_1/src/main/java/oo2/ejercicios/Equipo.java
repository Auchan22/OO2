package oo2.ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private List<Componente> componentes;

    public Equipo() {
        componentes = new ArrayList<Componente>();
    }

    public void add(Componente c){
        this.componentes.add(c);
    }

    public void agregarProcesador(Componente c){
        this.add(c);
    }

    public void agregarMemoriaRam(Componente c){
        this.add(c);
    }

    public void agregarDisco(Componente c){
        this.add(c);
    }

    public void agregarTarjetaGrafica(Componente c){
        this.add(c);
    }

    public void agregarGabinete(Componente c){
        this.add(c);
    }

    public double calcularConsumo(){
        return this.componentes.stream().mapToDouble(c -> c.getConsumo()).sum();
    }

    public double calcularPrecio(){
        return this.componentes.stream().mapToDouble(c -> c.getPrecio()).sum() * 1.21;
    }
}
