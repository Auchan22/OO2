package oo2.ejercicio2;

public class PendingState extends State {
    public PendingState(ToDoItem todo) {
        super(todo);
    }

    @Override
    public void start() {
        this.todo.changeState(new InProgressState(this.todo));
    }

    @Override
    public void pause() {
        throw new RuntimeException("El objeto ToDoItem no se encuentra en pause o in-progress");
    }

    @Override
    public void finish() {
    }
}
