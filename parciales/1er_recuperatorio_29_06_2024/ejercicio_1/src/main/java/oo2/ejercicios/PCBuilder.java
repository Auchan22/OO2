package oo2.ejercicios;

public abstract class PCBuilder {
    private Presupuesto presupuesto;

    public PCBuilder(){
        this.reset();
    }

    public void reset(){
        this.presupuesto = new Presupuesto();
    };

    public Presupuesto getPresupuesto(){
        return this.presupuesto;
    }

    public abstract void agregarProcesador();
    public abstract void agregarMemoria();
    public abstract void agregarDisco();
    public abstract void agregarTarjeta();
    public abstract void agregarGabinete();
}
