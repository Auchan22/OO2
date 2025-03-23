package oo2.ejercicio2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PapelTest {
    private Papel papel;

    @BeforeEach
    public void setUp(){
        this.papel = new Papel();
    }

    @Test
    public void testJugarContra(){
        assertEquals("Empate", papel.jugarContra(papel));
    }

    @Test
    public void testJugarContraPapel(){
        assertEquals("Empate", papel.jugarContraPapel());
    }

    @Test
    public void testJugarContraPiedra(){
        assertEquals("Gana Papel", papel.jugarContraPiedra());
    }

    @Test
    public void testJugarContraTijera(){
        assertEquals("Gana Tijera", papel.jugarContraTijera());
    }
}
