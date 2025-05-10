package oo2.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Computadora implements Equipo{
    private List<Componente> componentes;

    public Computadora() {
        componentes = new ArrayList<Componente>();
    }

    @Override
    public double calcularConsumo() {
        return this.componentes.stream().mapToDouble(c -> c.getConsumo()).sum();
    }

    @Override
    public double calcularPrecio() {
        double precio = this.componentes.stream().mapToDouble(c -> c.getPrecio()).sum();
        return precio * 1.21;
    }

    @Override
    public String getDescripcion() {
        return "";
    }
}
