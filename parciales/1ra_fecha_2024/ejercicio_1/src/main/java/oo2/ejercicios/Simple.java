package oo2.ejercicios;

public class Simple extends Prestamo{

    private double interes;
    private int cuotasPagadas;

    public Simple(Cliente cliente, double monto, double cantCuotas, double interes) {
        super(cliente, monto, cantCuotas);
        this.interes = interes;
        this.cuotasPagadas = 0;
    }

    @Override
    public double retornarIntereses() {
        return this.interes;
    }

    @Override
    public void pagarCuota() {
        this.cuotasPagadas++;
    }

    @Override
    public double calcularMontoPagado() {
        return this.cuotasPagadas * this.calcularCuota();
    }

    @Override
    public double obtenerValorSellado() {
        return 5000;
    }
}
