package oo2.ejercicio2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TijeraTest {
    private Tijera tijera;

    @BeforeEach
    public void setUp(){
        this.tijera = new Tijera();
    }

    @Test
    public void testJugarContra(){
        assertEquals("Empate", tijera.jugarContra(tijera));
    }

    @Test
    public void testJugarContraPapel(){
        assertEquals("Gana Tijera", tijera.jugarContraPapel());
    }

    @Test
    public void testJugarContraPiedra(){
        assertEquals("Gana Piedra", tijera.jugarContraPiedra());
    }

    @Test
    public void testJugarContraTijera(){
        assertEquals("Empate", tijera.jugarContraTijera());
    }
}
