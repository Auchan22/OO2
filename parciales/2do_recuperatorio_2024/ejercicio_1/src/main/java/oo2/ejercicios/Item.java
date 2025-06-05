package oo2.ejercicios;

public class Item implements Objeto {

    private int espacio;
    private String nombre;
    public Item(int espacio, String nombre) {
        this.espacio = espacio;
        this.nombre = nombre;
    }
    @Override
    public String getNombre() {
        return "";
    }

    @Override
    public int getEspacio() {
        return 0;
    }
}
