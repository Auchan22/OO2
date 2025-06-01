package oo2.ejercicios;

public class Aprobado implements State {
    @Override
    public void pagarCuota(Prestamo p) {
        p.pagarCuota();
        if(p.alcanzoCuotas()){
            p.setState(new Finalizado());
        }
    }

    @Override
    public double cancelarPrestamo(Prestamo p) {
        return 0;
    }
}
