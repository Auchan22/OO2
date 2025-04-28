package ar.edu.unlp.info.oo1.ejercicio_14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;



public class TestPrestamos {
    private PrendaCombinada prendaCombinada;
    private Prenda alquiler;
    private Prenda automovil;

    @BeforeEach
    public void setUp() throws Exception{
        this.prendaCombinada = new PrendaCombinada();

        this.alquiler = new Alquiler(LocalDate.of(2024, 10, 1), LocalDate.of(2026, 10, 1), 300);
        this.automovil = new Automovil(LocalDate.of(2010, 1, 1), 98000, 1200000);

        this.prendaCombinada.agregarPrenda(alquiler);
        this.prendaCombinada.agregarPrenda(automovil);
    }

    @Test
    public void testAlquiler(){
        assertEquals(5100, alquiler.calcularValor());
        assertEquals(4590, alquiler.calcularValorPrendario());
    }

    @Test
    public void testAutomovil(){
        assertEquals(0, automovil.calcularValor());
        assertEquals(0, automovil.calcularValorPrendario());
    }

    @Test
    public void testPrendaCombinada(){
        assertEquals(5100, prendaCombinada.calcularValor());
        assertEquals(2550, prendaCombinada.calcularValorPrendario());
    }
}
