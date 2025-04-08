package oo2.ejercicio2;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ToDoItem {
    private String name;
    private List<String> comments;
    private State state;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    public void changeState(State newState) {
        this.state = newState;
    }

    /**
     * Instancia un ToDoItem nuevo en estado pending con <name> como nombre.
     */
    public ToDoItem(String name){
        this.name = name;
        this.state = new PendingState(this);
        this.comments = new ArrayList<>();
    }

    /**
     * Pasa el ToDoItem a in-progress, siempre y cuando su estado actual sea
     * pending. Si se encuentra en otro estado, no hace nada.
     */
    public void start(){
        this.fechaInicio = LocalDateTime.now();
        this.state.start();
    }

    /**
     * Pasa el ToDoItem a paused si su estado es in-progress, o a in-progress si su
     * estado es paused. Caso contrario (pending o finished) genera un error
     * informando la causa específica del mismo.
     */
    public void togglePause(){
        this.state.pause();
    }


    /**
     * Pasa el ToDoItem a finished, siempre y cuando su estado actual sea
     * in-progress o paused. Si se encuentra en otro estado, no hace nada.
     */
    public void finish(){
        this.fechaFin = LocalDateTime.now();
        this.state.finish();
    }


    /**
     * Retorna el tiempo que transcurrió desde que se inició el ToDoItem (start)
     * hasta que se finalizó. En caso de que no esté finalizado, el tiempo que
     * haya transcurrido hasta el momento actual. Si el ToDoItem no se inició,
     * genera un error informando la causa específica del mismo.
     */
    public Duration workedTime(){
        if(null == this.fechaInicio){
            throw new RuntimeException("El objeto ToDoItem no fue iniciado");
        }

        return Duration.between(fechaInicio,
                fechaFin != null ? fechaFin : LocalDateTime.now());
    }


    /**
     * Agrega un comentario al ToDoItem siempre y cuando no haya finalizado. Caso
     * contrario no hace nada."
     */
    public void addComment(String comment){
        if(null == this.fechaFin){
            this.comments.add(comment);
        }
    }

}
