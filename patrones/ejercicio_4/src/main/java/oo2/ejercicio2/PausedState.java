package oo2.ejercicio2;

public class PausedState extends State {
    public PausedState(ToDoItem todo) {
        super(todo);
    }

    @Override
    public void start() {
    }

    @Override
    public void pause() {
        this.todo.changeState(new InProgressState(this.todo));
    }

    @Override
    public void finish() {
        this.todo.changeState(new FinishedState(this.todo));
    }
}
