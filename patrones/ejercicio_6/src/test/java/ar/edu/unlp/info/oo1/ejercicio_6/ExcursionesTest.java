package ar.edu.unlp.info.oo1.ejercicio_6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExcursionesTest {
	private Excursion e;
	private Usuario u1;
	private Usuario u2;
	
	@BeforeEach
	public void setUp() throws Exception {
		
		u1 = new Usuario("Pepe", "Eme", "pepeme@gmail.com");
		u2 = new Usuario("Juan", "Hache", "juanh@gmail.com");
		
		this.e = new Excursion("Dos días en kayak bajando el Paraná", LocalDate.now(), LocalDate.of(2025, 4, 17), "Avellaneda", 10000, 1, 2);

	}
	
	@Test
	public void testExcursionProvisoria() {
		assertEquals(2, this.e.cantUsuariosRestantesMaximo());
		assertEquals(1, this.e.cantUsuariosRestantesMinimo());
		System.out.println(this.e.obtenerInformacion());
	}
	
	@Test
	public void testExcursionDefinitiva() {
		this.e.agregarUsuario(u1);
		assertEquals(1, this.e.cantUsuariosRestantesMaximo());
		assertEquals(0, this.e.cantUsuariosRestantesMinimo());
		System.out.println(this.e.obtenerInformacion());
	}
	
	@Test
	public void testExcursionCompleta() {
		this.e.agregarUsuario(u1);
		this.e.agregarUsuario(u2);
		assertEquals(0, this.e.cantUsuariosRestantesMaximo());
		assertEquals(0, this.e.cantUsuariosRestantesMinimo());
		Usuario u3 = new Usuario("Miguel", "Jota", "miguelj@gmail.com");
		this.e.agregarUsuario(u3);
		assertEquals(1, this.e.getEspera().size());
	}
}
