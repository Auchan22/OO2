package ar.edu.unlp.info.oo1.ejercicio_14;

public class Inmueble extends PrendaBase{
    private String direccion;
    private double superficie;
    private double costo_mcuadrado;

    public Inmueble(String direccion, double superficie, double costo){
        super(0.2);
        this.direccion = direccion;
        this.superficie = superficie;
        this.costo_mcuadrado = costo;
    }


    @Override
    public double calcularValor() {
        return this.superficie * this.costo_mcuadrado;
    }
}
