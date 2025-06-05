package oo2.ejercicios;

public class Iniciada extends EstadoTarea{
    public Iniciada(Simple tareaSimple) {
        super(tareaSimple);
    }

    @Override
    public void iniciarTarea() {
        //throw new Error("La tarea ya se encuentra iniciada.");
    }

    @Override
    public void completarTarea() {
        Simple tarea = this.obtenerTareaSimple();
        tarea.setMomentoFin(System.currentTimeMillis());
        tarea.cambiarEstado(new Completada(tarea));
    }
}
