package ar.edu.unlp.info.oo1.ejercicio_8;

public class FourGConnection {
	private String symb;
	
	public FourGConnection() {
		this.symb = "4G";
	}
	
	public String transmit(String data, long crc) {
		return this.symb + ": "+ data + " "+crc;
	}
	
	public String getSymb() {
		return this.symb;
	}
}
