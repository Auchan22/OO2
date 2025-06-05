package oo2.ejercicios;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParcialTest {
    private Compleja compleja;

    @BeforeEach
    public void setUp() throws Exception {
        compleja = new Compleja("preparar almuerzo");
        Compleja subCompleja = new Compleja("realizar compras");
        Tarea simple1 = new Simple("ir al supermercado", 3);
        Tarea simple2 = new Simple("ir a la verduleria", 1);
        Tarea simple3 = new Simple("cocinar", 2);
        Tarea simple4 = new Simple("preparar la mesa", 1);

        simple1.iniciarTarea();
        Thread.sleep(2); // 3 o 4
        simple1.completarTarea();
        simple2.iniciarTarea();
        Thread.sleep(1); // 2 o 3
        simple2.completarTarea();
        simple3.iniciarTarea();

        subCompleja.agregarTarea(simple1);
        subCompleja.agregarTarea(simple2);
        compleja.agregarTarea(subCompleja);
        compleja.agregarTarea(simple3);
        compleja.agregarTarea(simple4);
    }

    @Test
    public void testSimple(){
        System.out.println(compleja.calcularAvanceTarea());
        System.out.println(compleja.tiempoUtilizado());
        System.out.println(compleja.calcularEstimacion());
    }
}
