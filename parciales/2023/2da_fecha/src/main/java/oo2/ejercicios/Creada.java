package oo2.ejercicios;

public class Creada extends EstadoTarea{
    public Creada(Simple tareaSimple) {
        super(tareaSimple);
    }

    @Override
    public void iniciarTarea() {
        Simple tarea = this.obtenerTareaSimple();
        tarea.setMomentoInicio(System.currentTimeMillis());
        tarea.cambiarEstado(new Iniciada(tarea));
    }

    @Override
    public void completarTarea() {
        //throw new Error("No se puede completar la tarea si no fue iniciada.");
    }
}
