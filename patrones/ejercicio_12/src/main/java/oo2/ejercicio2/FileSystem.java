package oo2.ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileSystem {

    private Directorio raiz;

    public FileSystem(String nombreRaiz) {
        this.raiz = new Directorio(nombreRaiz, LocalDate.now());
    }

    public Directorio getRaiz() {
        return raiz;
    }

    public int tamanoTotalOcupado() {
        return raiz.getTamano();
    }

    public Archivo archivoMasGrande() {
        return raiz.archivoMasGrande();
    }

    public Archivo archivoMasNuevo() {
        return raiz.archivoMasNuevo();
    }

    public ElementFileSystem buscar(String nombre) {
        return raiz.buscar(nombre);
    }

    public List<ElementFileSystem> buscarTodos(String nombre) {
        return raiz.buscarTodos(nombre);
    }

    public String listadoDeContenido() {
        StringBuilder sb = new StringBuilder();
        raiz.listar(sb, "");
        return sb.toString();
    }
}
