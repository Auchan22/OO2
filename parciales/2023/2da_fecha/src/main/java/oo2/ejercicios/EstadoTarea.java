package oo2.ejercicios;

public abstract class EstadoTarea {
    private Simple tareaSimple;

    public EstadoTarea(Simple tareaSimple) {
        this.tareaSimple = tareaSimple;
    }

    public Simple obtenerTareaSimple() {
        return tareaSimple;
    }

    public abstract void iniciarTarea();
    public abstract void completarTarea();
    public long calcularTiempoUtilizado(){
        return 0;
    };
}
