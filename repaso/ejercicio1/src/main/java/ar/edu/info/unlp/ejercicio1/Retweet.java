package ar.edu.info.unlp.ejercicio1;

public class Retweet implements Post {
    private Tweet tweetOrigen;

    public Retweet(Tweet tweetOrigen) {
        this.tweetOrigen = tweetOrigen;
    }

    @Override
    public String getTexto() {
        return this.tweetOrigen.getTexto();
    }

    @Override
    public Boolean esRetweet() {
        return true;
    }

    public Tweet getTweetOrigen() {
        return this.tweetOrigen;
    }
}
