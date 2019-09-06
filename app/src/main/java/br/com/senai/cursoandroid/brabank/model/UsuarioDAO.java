package br.com.senai.cursoandroid.brabank.model;

import java.util.ArrayList;
import java.util.List;

import br.com.senai.cursoandroid.brabank.model.entity.Usuario;

public class UsuarioDAO {

    private List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> listarTodos(){
        return usuarios;
    }

    public Usuario buscarPorEmail(String email){
        //percorrer a lista
        for (Usuario u : usuarios) {
            if(u.email.equals(email)){
                return u;
            }
        }
        return null;
    }

    public Usuario buscarPorId(){

        return null;
    }

    public boolean inserir(Usuario usuario){
        return usuarios.add(usuario);
    }

    public boolean editar(Usuario usuario){
        //implemntar update
        return false;
    }

    public boolean excluir(Usuario usuario){
        return usuarios.remove(usuario);
    }

}
