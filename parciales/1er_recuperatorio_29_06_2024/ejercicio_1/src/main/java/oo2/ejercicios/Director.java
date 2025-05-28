package oo2.ejercicios;

public class Director {

    private PCBuilder builder;

    public Director(){
    }

    public void setBuilder(PCBuilder builder) {
        this.builder = builder;
    }

    public Presupuesto crearPresupuesto(String nombre){
        this.builder.reset();
        this.builder.agregarProcesador();
        this.builder.agregarMemoria();
        this.builder.agregarDisco();
        this.builder.agregarTarjeta();
        this.builder.agregarGabinete();
        Presupuesto p = this.builder.getPresupuesto();
        p.setNombre(nombre);
        return p;
    }
}
