package oo2.ejercicio2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PiedraTest {
    private Piedra piedra;

    @BeforeEach
    public void setUp(){
        this.piedra = new Piedra();
    }

    @Test
    public void testJugarContra(){
        assertEquals("Empate", piedra.jugarContra(piedra));
    }

    @Test
    public void testJugarContraPapel(){
        assertEquals("Gana Papel", piedra.jugarContraPapel());
    }

    @Test
    public void testJugarContraPiedra(){
        assertEquals("Empate", piedra.jugarContraPiedra());
    }

    @Test
    public void testJugarContraTijera(){
        assertEquals("Gana Piedra", piedra.jugarContraTijera());
    }
}
