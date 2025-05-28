package oo2.ejercicios;

public class BuilderIntermedio extends PCBuilder{
    @Override
    public void agregarProcesador() {
        this.getPresupuesto().obtenerEquipo().agregarProcesador(Catalogo.getComponente("Procesador intermedio"));
    }

    @Override
    public void agregarMemoria() {
        this.getPresupuesto().obtenerEquipo().agregarMemoriaRam(Catalogo.getComponente("16 gb"));
    }

    @Override
    public void agregarDisco() {
        this.getPresupuesto().obtenerEquipo().agregarDisco(Catalogo.getComponente("SSD 500 gb"));
    }

    @Override
    public void agregarTarjeta() {
        this.getPresupuesto().obtenerEquipo().agregarTarjetaGrafica(Catalogo.getComponente("GTX 1650"));
    }

    @Override
    public void agregarGabinete() {
        this.getPresupuesto().obtenerEquipo().agregarGabinete(Catalogo.getComponente("Gabinete intermedio"));
        this.getPresupuesto().obtenerEquipo().add(Catalogo.getComponente("Fuente 800 w"));
    }
}
