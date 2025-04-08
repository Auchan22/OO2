package oo2.ejercicio2;

public class FinishedState extends State{
    public FinishedState(ToDoItem todo) {
        super(todo);
    }

    @Override
    public void start() {
    }

    @Override
    public void pause() {
        throw new RuntimeException("El objeto ToDoItem no se encuentra en pause o in-progress");
    }

    @Override
    public void finish() {
    }
}
