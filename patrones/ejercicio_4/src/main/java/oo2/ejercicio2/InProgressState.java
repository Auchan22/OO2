package oo2.ejercicio2;

public class InProgressState extends State{
    public InProgressState(ToDoItem todo) {
        super(todo);
    }

    @Override
    public void start() {
    }

    @Override
    public void pause() {
        this.todo.changeState(new PausedState(this.todo));
    }

    @Override
    public void finish() {
        this.todo.changeState(new FinishedState(this.todo));
    }
}
