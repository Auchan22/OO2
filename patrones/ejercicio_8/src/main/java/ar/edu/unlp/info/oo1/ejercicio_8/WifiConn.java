package ar.edu.unlp.info.oo1.ejercicio_8;

public class WifiConn implements Connection {
	
	private String pict;
	
	public WifiConn() {
		this.pict = "WIFI";
	}

	@Override
	public String sendData(String data, long crc) {
		return this.pict + ": "+ data + " "+crc;
	}

	@Override
	public String pict() {
		return this.pict;
	}

}
