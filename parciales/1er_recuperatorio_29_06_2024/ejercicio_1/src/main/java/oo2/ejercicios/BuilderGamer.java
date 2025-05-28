package oo2.ejercicios;

public class BuilderGamer extends PCBuilder{
    @Override
    public void agregarProcesador() {
        this.getPresupuesto().obtenerEquipo().agregarProcesador(Catalogo.getComponente("Procesador gamer"));
        this.getPresupuesto().obtenerEquipo().add(Catalogo.getComponente("Pad térmico"));
        this.getPresupuesto().obtenerEquipo().add(Catalogo.getComponente("Cooler"));
    }

    @Override
    public void agregarMemoria() {
        this.getPresupuesto().obtenerEquipo().agregarMemoriaRam(Catalogo.getComponente("32 gb"));
        this.getPresupuesto().obtenerEquipo().agregarMemoriaRam(Catalogo.getComponente("32 gb"));
    }

    @Override
    public void agregarDisco() {
        this.getPresupuesto().obtenerEquipo().agregarDisco(Catalogo.getComponente("SSD 500 gb"));
        this.getPresupuesto().obtenerEquipo().agregarDisco(Catalogo.getComponente("HDD 1 tb"));
    }

    @Override
    public void agregarTarjeta() {
        this.getPresupuesto().obtenerEquipo().agregarTarjetaGrafica(Catalogo.getComponente("RTX 4090"));
    }

    @Override
    public void agregarGabinete() {
        Equipo equipo = this.getPresupuesto().obtenerEquipo();
        equipo.agregarGabinete(Catalogo.getComponente("Gabinete gamer"));
        equipo.add(Catalogo.getComponente("Fuente "+equipo.calcularConsumo() * 1.50 +" w"));
    }
}
