package oo2.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Componente> componentes;

    public Catalogo() {
        componentes = new ArrayList<Componente>();
    }

    public Componente getComponente(String descripcion) {
        return this.componentes.stream().filter(comp -> comp.getDescripcion().equals(descripcion)).findFirst().orElse(null);
    }
}
