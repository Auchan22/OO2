package oo2.ejercicio2;

import java.time.LocalDate;

public class MainFileSystem {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem("root");

        Directorio dirA = new Directorio("Directorio A", LocalDate.now().minusDays(3));
        Directorio dirA1 = new Directorio("Directorio A.1", LocalDate.now().minusDays(2));
        Archivo a1 = new Archivo("archivo1.txt", LocalDate.now().minusDays(1), 2000);
        Archivo a2 = new Archivo("archivo2.txt", LocalDate.now(), 3000);

        dirA1.agregar(a1);
        dirA1.agregar(a2);
        dirA.agregar(dirA1);
        fs.getRaiz().agregar(dirA);

        System.out.println("Tamaño total ocupado: " + fs.tamanoTotalOcupado() + " bytes");
        System.out.println("Archivo más grande: " + fs.archivoMasGrande().getNombre());
        System.out.println("Archivo más nuevo: " + fs.archivoMasNuevo().getNombre());
        System.out.println("Listado de contenido:");
        System.out.println(fs.listadoDeContenido());
    }
}
