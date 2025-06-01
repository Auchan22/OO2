package oo2.ejercicios;

public class Rechazado implements State {
    @Override
    public void pagarCuota(Prestamo p) {
        throw new Error ("El prestamo esta rechazado, no se puede pagar cuota");
    }

    @Override
    public double cancelarPrestamo(Prestamo p) {
        throw new Error ("El prestamo esta rechazado, no se puede cancelar");
    }
}
