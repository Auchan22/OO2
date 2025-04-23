package oo2.ejercicio2;

import java.time.LocalDate;
import java.util.List;

public class Archivo implements ElementFileSystem {

    private int tamanio;
    private String nombre;
    private LocalDate fechaCreacion;

    public Archivo(String nombre, LocalDate fechaCreacion, int tamanio) {
        this.fechaCreacion = fechaCreacion;
        this.nombre = nombre;
        this.tamanio = tamanio;
    }


    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public LocalDate getFechaCreacion() {
        return this.fechaCreacion;
    }

    @Override
    public int getTamano() {
        return this.tamanio;
    }

    @Override
    public ElementFileSystem buscar(String nombre) {
        return this.nombre.equals(nombre) ? this : null;
    }

    @Override
    public List<ElementFileSystem> buscarTodos(String nombre) {
        return this.nombre.equals(nombre) ? List.of(this) : List.of();
    }

    @Override
    public void listar(StringBuilder sb, String path) {
        sb.append(path).append("/").append(nombre).append("\n");
    }

    @Override
    public Archivo archivoMasGrande() {
        return this;
    }

    @Override
    public Archivo archivoMasNuevo() {
        return this;
    }
}
