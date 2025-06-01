package oo2.ejercicios;

import java.util.ArrayList;
import java.util.List;

public class UVA extends Prestamo{
    private List<Double> pagos;

    public UVA(Cliente cliente, double monto, double cantCuotas) {
        super(cliente, monto, cantCuotas);
        this.pagos = new ArrayList<Double>();
    }

    @Override
    public double retornarIntereses() {
        return Indec.getIndiceInflacion();
    }

    @Override
    public void pagarCuota() {
        this.pagos.add(this.calcularCuota());
    }

    @Override
    public double calcularMontoPagado() {
        return this.pagos.stream().mapToDouble(Double::doubleValue).sum();
    }

    @Override
    public double obtenerValorSellado() {
        return 0;
    }
}
