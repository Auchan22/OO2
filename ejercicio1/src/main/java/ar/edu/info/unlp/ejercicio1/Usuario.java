package ar.edu.info.unlp.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String screenName;
    private List<Post> posts;

    public Usuario(String screenName) {
        this.screenName = screenName;
        this.posts = new ArrayList<Post>();
    }

    private Boolean cumpleLongitud(String t){
        return (!t.isEmpty()) && (t.length() <= 280);
    }

    public String getScreenName() {
        return screenName;
    }

    public List<Post> getPosts() {
        return new ArrayList<>(this.posts);
    }

    public void crearTweet(String texto){
        Tweet t = null;
        if(this.cumpleLongitud(texto)){
            t = new Tweet(texto);
            this.posts.add(t);
        }
    }

    public void crearRetweet(Tweet t){
        Retweet r = new Retweet(t);
        this.posts.add(r);
    }

    public void eliminarPosts(){
        this.posts.clear();
    }

    public void eliminarPost(Post p){
        this.posts.remove(p);
    }
}
