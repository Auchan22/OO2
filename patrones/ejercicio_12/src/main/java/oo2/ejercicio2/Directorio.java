package oo2.ejercicio2;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Directorio implements ElementFileSystem {

    private List<ElementFileSystem> archivos;
    private String nombre;
    private LocalDate fechaCreacion;

    public Directorio(String nombre, LocalDate fechaCreacion) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.archivos = new ArrayList<ElementFileSystem>();
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
        return (32*1024)+ this.archivos.stream().mapToInt(ElementFileSystem::getTamano).sum();
    }

    @Override
    public ElementFileSystem buscar(String nombre) {
        if (this.nombre.equals(nombre)) return this;
        for (ElementFileSystem e : archivos) {
            ElementFileSystem res = e.buscar(nombre);
            if (res != null) return res;
        }
        return null;
    }

    public void agregar(ElementFileSystem e) {
        archivos.add(e);
    }

    @Override
    public List<ElementFileSystem> buscarTodos(String nombre) {
        List<ElementFileSystem> encontrados = new ArrayList<>();
        if (this.nombre.equals(nombre)) encontrados.add(this);
        for (ElementFileSystem e : archivos) {
            encontrados.addAll(e.buscarTodos(nombre));
        }
        return encontrados;
    }

    public void listar(StringBuilder sb, String path) {
        String actual = path + "/" + nombre;
        sb.append(actual).append("\n");
        for (ElementFileSystem e : archivos) {
            e.listar(sb, actual);
        }
    }

    public Archivo archivoMasGrande() {
        Archivo mayor = null;
        for (ElementFileSystem e : archivos) {
            Archivo a = e.archivoMasGrande();
            if (a != null && (mayor == null || a.getTamano() > mayor.getTamano())) {
                mayor = a;
            }
        }
        return mayor;
    }

    public Archivo archivoMasNuevo() {
        Archivo nuevo = null;
        for (ElementFileSystem e : archivos) {
            Archivo a = e.archivoMasNuevo();
            if (a != null && (nuevo == null || a.getFechaCreacion().isAfter(nuevo.getFechaCreacion()))) {
                nuevo = a;
            }
        }
        return nuevo;
    }
}
