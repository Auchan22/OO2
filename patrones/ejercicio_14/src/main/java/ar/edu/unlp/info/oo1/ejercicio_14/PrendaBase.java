package ar.edu.unlp.info.oo1.ejercicio_14;

public abstract class PrendaBase implements Prenda {
    public double liquidez;

    public PrendaBase(double liquidez) {
        this.liquidez = liquidez;
    }

    @Override
    public abstract double calcularValor();

    public double calcularValorPrendario(){
        return this.liquidez * calcularValor();
    };

    public double getLiquidez() {
        return liquidez;
    }
}
