package oo2.ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private static List<Componente> componentes;

    public Catalogo() {
        componentes = new ArrayList<>();
    }
    public static Componente getComponente(String descripcion){
        return componentes.stream().filter(comp -> comp.getDescripcion().equals(descripcion)).findFirst().orElse(null);
    }

    public static void setComponentes(List<Componente> componentes) {
        Catalogo.componentes = componentes;
    }
}
