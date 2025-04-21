package ar.edu.unlp.info.oo1.ejercicio_8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DispositivoTest {
	private Dispositivo dispositivo;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.dispositivo = new Dispositivo();
	}
	
	@Test
	void testSendCRC16Wifi() {
		assertEquals("WIFI: Cuando lo sabes lo sabes 15071", this.dispositivo.send("Cuando lo sabes lo sabes"));
	}
	
	@Test
	void testSendCRC32Wifi() {
		this.dispositivo.configurarCRC(new CRC32_Calculator());
		assertEquals("WIFI: Cuando lo sabes lo sabes 2553470133", this.dispositivo.send("Cuando lo sabes lo sabes"));
	}
	
	@Test
	void testSendCRC164G() {
		this.dispositivo.conectarCon(new FourGAdapter());
		assertEquals("4G: Cuando lo sabes lo sabes 15071", this.dispositivo.send("Cuando lo sabes lo sabes"));
	}
	
	@Test
	void testSendCRC324G() {
		this.dispositivo.conectarCon(new FourGAdapter());
		this.dispositivo.configurarCRC(new CRC32_Calculator());
		assertEquals("4G: Cuando lo sabes lo sabes 2553470133", this.dispositivo.send("Cuando lo sabes lo sabes"));
	}
	
	@Test
	void testConectarCon() {
		assertEquals("Connection has changed", this.dispositivo.conectarCon(new FourGAdapter()));
		assertEquals("Connection has changed", this.dispositivo.conectarCon(new WifiConn()));
	}
	
	@Test
	void testConfigurarCRC() {
		assertEquals("CRC Configuration has changed", this.dispositivo.configurarCRC(new CRC32_Calculator()));
		assertEquals("CRC Configuration has changed", this.dispositivo.configurarCRC(new CRC16_Calculator()));
	}
}
