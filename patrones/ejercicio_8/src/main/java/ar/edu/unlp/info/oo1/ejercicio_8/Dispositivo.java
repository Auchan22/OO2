package ar.edu.unlp.info.oo1.ejercicio_8;

public class Dispositivo {
	private CRC_Calculator crcCalculator;
	private Connection connection;
	private Ringer ring;
	private Display display;
	
	public Dispositivo() {
		this.connection = new WifiConn();
		this.crcCalculator = new CRC16_Calculator();
		this.ring = new Ringer();
		this.display = new Display();
	}
	
	public void setCRCCalculator(CRC_Calculator c) {
		this.crcCalculator = c;
	}
	
	public String send(String data) {
		long crc = this.crcCalculator.crcFor(data);
		return this.connection.sendData(data, crc);
	}
	
	public String conectarCon(Connection c) {
		this.connection = c;
		this.display.showBanner(c.pict());
		this.ring.ring();
		return "Connection has changed";
	}
	
	public String configurarCRC(CRC_Calculator strategy) {
		this.crcCalculator = strategy;
		return "CRC Configuration has changed";
	}
}
