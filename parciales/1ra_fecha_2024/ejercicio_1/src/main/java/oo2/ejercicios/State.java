package oo2.ejercicios;

public interface State {
    void pagarCuota(Prestamo p);
    double cancelarPrestamo(Prestamo p);
}
