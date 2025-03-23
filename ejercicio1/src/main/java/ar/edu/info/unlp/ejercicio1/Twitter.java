package ar.edu.info.unlp.ejercicio1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Twitter {
    private Set<Usuario> usuariosList;

    public Twitter() {
        this.usuariosList = new HashSet<Usuario>();
    }

    public void agregarUsuario(String screenName) throws Exception {
        Usuario u = new Usuario(screenName);
        if(this.usuariosList.contains(u)){
            throw new Exception("El usuario ya existe");
        }
        this.usuariosList.add(u);
    }

    public void eliminarUsuario(Usuario u) throws Exception {
        if(!this.usuariosList.contains(u)){
            throw new Exception("El usuario no existe");
        }
        u.eliminarPosts();
        this.usuariosList.remove(u);
    }

    public List<Usuario> getUsuarios() {
        return new ArrayList<>(this.usuariosList);
    }
}
