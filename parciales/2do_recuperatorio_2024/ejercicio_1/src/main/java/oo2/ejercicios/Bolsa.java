package oo2.ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Bolsa implements Objeto {
    private List<Objeto> items;
    private int espacio;
    private int capacidad;
    private String nombre;

    public Bolsa(int espacio, String nombre, int capacidad) {
        this.espacio = espacio;
        this.nombre = nombre;
        this.capacidad = capacidad;
        items = new ArrayList<Objeto>();
    }


    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public int getEspacio() {
        return this.espacio;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public boolean agregarItem(Objeto item) {
        if (capacidadDisponible() >= item.getEspacio()) {
            items.add(item);
            return true;
        }
        return false;
    }

    public int capacidadDisponible() {
        return capacidad - items.stream().mapToInt(Objeto::getEspacio).sum();
    }

    public Objeto buscarItemPorNombre(String nombre) {
        for (Objeto i : items) {
            if (i.getNombre().equals(nombre)) return i;
            if (i instanceof Bolsa) {
                Objeto encontrado = ((Bolsa) i).buscarItemPorNombre(nombre);
                if (encontrado != null) return encontrado;
            }
        }
        return null;
    }

    public int espacioMasGrande() {
        int max = capacidadDisponible();
        for (Objeto i : items) {
            if (i instanceof Bolsa) {
                max = Math.max(max, ((Bolsa) i).espacioMasGrande());
            }
        }
        return max;
    }

    public int capacidadTotalDisponible() {
        int total = capacidadDisponible();
        for (Objeto i : items) {
            if (i instanceof Bolsa) {
                total += ((Bolsa) i).capacidadTotalDisponible();
            }
        }
        return total;
    }
}
