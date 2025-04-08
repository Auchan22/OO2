package oo2.ejercicio2;

public abstract class State {
    protected ToDoItem todo;

    public State(ToDoItem todo) {
        this.todo = todo;
    }

    public abstract void start();
    public abstract void pause();
    public abstract void finish();
}
