package ar.edu.unlp.info.oo2.ejercicio_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonalTest {
    private Temporario temporario;
    private Pasante pasante;
    private Planta planta;

    @BeforeEach
    public void setUp() throws Exception{
        this.temporario = new Temporario(10, false, 3);
        this.planta = new Planta(true, 2, 15);
        this.pasante = new Pasante(8);
    }

    @Test
    public void testPasante(){
        assertEquals(20000, pasante.basico());
        assertEquals(16000, pasante.adicional());
        assertEquals(3400, pasante.descuento());
        assertEquals(32600, pasante.sueldo());
    }

    @Test
    public void testTemporario(){
        assertEquals(23000, temporario.basico());
        assertEquals(6000, temporario.adicional());
        assertEquals(3290, temporario.descuento());
        assertEquals(25710, temporario.sueldo());
    }

    @Test
    public void testPlanta(){
        assertEquals(50000, planta.basico());
        assertEquals(39000, planta.adicional());
        assertEquals(8450, planta.descuento());
        assertEquals(80550, planta.sueldo());
    }
}
