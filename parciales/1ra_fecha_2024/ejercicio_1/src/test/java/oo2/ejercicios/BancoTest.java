package oo2.ejercicios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BancoTest {
    private Cliente cliente;
    private Banco banco;

    @BeforeEach
    public void setUp() throws Exception {
        this.cliente = new Cliente("Pepe", 5000);
        this.banco = new Banco(0.05);
    }

    @Test
    public void testPrestamoSimple(){
        Prestamo simple = this.banco.SolicitarPrestamoSimple(10, 100, this.cliente);
    }
}
