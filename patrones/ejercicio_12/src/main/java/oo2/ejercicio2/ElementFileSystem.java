package oo2.ejercicio2;

import java.time.LocalDate;
import java.util.List;

public interface ElementFileSystem {
    String getNombre();
    LocalDate getFechaCreacion();
    int getTamano();
    ElementFileSystem buscar(String nombre);
    List<ElementFileSystem> buscarTodos(String nombre);
    void listar(StringBuilder sb, String path);
    Archivo archivoMasGrande();
    Archivo archivoMasNuevo();
}
