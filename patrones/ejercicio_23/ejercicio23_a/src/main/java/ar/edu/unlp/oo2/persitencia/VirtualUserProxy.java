package ar.edu.unlp.oo2.persitencia;

import java.util.List;

public class VirtualUserProxy implements PersistableUser{
    private String username;
    private String email;
    private User realUser;
    private PostRepository repo;

    public VirtualUserProxy(String username, String email){
        this.username = username;
        this.email = email;
    }
    private void initialize(){
        if(realUser == null){
            this.realUser = new User(this.username, this.email);
            this.repo = new PostRepository();
            List<Post> posts = this.repo.findPostsByUsername(this.username);
            realUser.addPosts(posts);
        }
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public List<Post> getPosts() {
        this.initialize();
        return realUser.getPosts();
    }
}
