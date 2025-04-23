package ar.edu.unlp.info.oo1.ejercicio_11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TopografiaTest {
	private Topografia tpmixta;
	
	@BeforeEach
	public void setUp() throws Exception {
		Topografia tpagua1 = new TopografiaAgua();
		Topografia tpagua2 = new TopografiaAgua();
		Topografia tptierra1 = new TopografiaTierra();
		Topografia tptierra2 = new TopografiaTierra();
		this.tpmixta = new TopografiaMixta(tpagua1, tptierra1, tpagua2, tptierra2);
	}
	
	@Test
	public void test() {
		assertEquals(0.5, this.tpmixta.getProporcionAgua());
	}
}
