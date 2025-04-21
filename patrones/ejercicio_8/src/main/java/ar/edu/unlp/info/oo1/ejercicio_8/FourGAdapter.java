package ar.edu.unlp.info.oo1.ejercicio_8;

public class FourGAdapter implements Connection {
	
	private FourGConnection conn;
	
	public FourGAdapter() {
		this.conn = new FourGConnection();
	}

	@Override
	public String sendData(String data, long crc) {
		return this.conn.transmit(data, crc);
	}

	@Override
	public String pict() {
		return this.conn.getSymb();
	}

}
