package ar.edu.unlp.info.oo2.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BibliotecaTest {

	private Biblioteca biblioteca;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.biblioteca = new Biblioteca();
		this.biblioteca.setExporter(new JSONSimpleAdapter());
	}
	
	@Test
	public void textExportarSocios() throws ParseException {
		JSONParser parser = new JSONParser();
		String textoSalida = "[\n"
				+ "	{\n"
				+ "		\"nombre\": \"Arya Stark\",\n"
				+ "		\"email\": \"needle@stark.com\",\n"
				+ "		\"legajo\": \"5234-5\"\n"
				+ "	},\n"
				+ "	{\n"
				+ "		\"nombre\": \"Tyron Lannister\",\n"
				+ "		\"email\": \"tyron@thelannisters.com\",\n"
				+ "		\"legajo\": \"2345-2\"\n"
				+ "	}\n"
				+ "]\n"
				+ "";
		
		assertEquals(parser.parse("[]"),parser.parse(this.biblioteca.exportarSocios())); //VACIO
		
		biblioteca.agregarSocio(new Socio("Arya Stark", "needle@stark.com", "5234-5"));
		biblioteca.agregarSocio(new Socio("Tyron Lannister", "tyron@thelannisters.com",  "2345-2"));
		
		//System.out.println(this.biblioteca.exportarSocios());
		
		assertEquals(parser.parse(textoSalida),parser.parse(this.biblioteca.exportarSocios()));
	}

}
