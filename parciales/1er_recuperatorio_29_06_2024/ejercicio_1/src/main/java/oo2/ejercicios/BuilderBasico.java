package oo2.ejercicios;

public class BuilderBasico extends PCBuilder{
    @Override
    public void agregarProcesador() {
        this.getPresupuesto().obtenerEquipo().agregarProcesador(Catalogo.getComponente("Procesador básico"));
    }

    @Override
    public void agregarMemoria() {
        this.getPresupuesto().obtenerEquipo().agregarMemoriaRam(Catalogo.getComponente("8 gb"));
    }

    @Override
    public void agregarDisco() {
        this.getPresupuesto().obtenerEquipo().agregarDisco(Catalogo.getComponente("HDD 500 gb"));
    }

    @Override
    public void agregarTarjeta() {
        this.getPresupuesto().obtenerEquipo().agregarTarjetaGrafica(null);
    }

    @Override
    public void agregarGabinete() {
        this.getPresupuesto().obtenerEquipo().agregarGabinete(Catalogo.getComponente("Gabinete estándar"));
    }
}
