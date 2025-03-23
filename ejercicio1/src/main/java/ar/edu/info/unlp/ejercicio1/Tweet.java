package ar.edu.info.unlp.ejercicio1;

public class Tweet implements Post{
    private String texto;

    public Tweet(String texto) {
        this.texto = texto;
    }

    @Override
    public String getTexto() {
        return texto;
    }

    @Override
    public Boolean esRetweet() {
        return false;
    }
}
