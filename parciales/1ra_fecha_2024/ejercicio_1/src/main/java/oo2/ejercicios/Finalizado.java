package oo2.ejercicios;

public class Finalizado implements State{
    @Override
    public void pagarCuota(Prestamo p) {
        throw new Error ("El prestamo fue finalizado, no se puede pagar cuota.");
    }

    @Override
    public double cancelarPrestamo(Prestamo p) {
        return 0;
    }
}
