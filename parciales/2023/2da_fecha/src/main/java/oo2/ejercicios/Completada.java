package oo2.ejercicios;

public class Completada extends EstadoTarea{
    public Completada(Simple tareaSimple) {
        super(tareaSimple);
    }

    @Override
    public void iniciarTarea() {
        //throw new Error("No se puede iniciar una tarea completada.");
    }

    @Override
    public void completarTarea() {
        //throw new Error("La tarea ya fue completada.");
    }

    @Override
    public long calcularTiempoUtilizado() {
        Simple tarea = this.obtenerTareaSimple();
        return tarea.getMomentoFin() - tarea.getMomentoInicio();
    }
}
