package com.conectarural.conecta_rural.dados;

import com.conectarural.conecta_rural.exceptions.ElementoJaExistenteException;
import com.conectarural.conecta_rural.exceptions.ElementoNaoExistenteException;
import com.conectarural.conecta_rural.models.Usuario;

import java.util.List;
import java.util.ArrayList;

public class UsuarioRepository implements IRepository<Usuario>{
    private List<Usuario> usuarios;

    public UsuarioRepository(){
        this.usuarios = new ArrayList<>();
    }

    public void adicionar(Usuario U)throws ElementoJaExistenteException {
        boolean existe = usuarios.contains(U);
        if(!existe){
            this.usuarios.add(U);
        }else{
            throw new ElementoJaExistenteException();
        }
    }

    public void remover(Usuario U) throws ElementoNaoExistenteException {
        boolean existe = false;
        for(Usuario usuario : usuarios){
            if(U.getEmail() == usuario.getEmail()) {
                existe = true;
            }
        }
        if(existe){
            usuarios.remove(U);
        }
        else{
            throw new ElementoNaoExistenteException();
        }
    }

    public void atualizar(Usuario Antigo,Usuario Novo)throws ElementoNaoExistenteException {
        int indice=procurarIndice(Antigo);

        if(indice>=0){
            this.usuarios.set(indice, Novo);
        }else{
            throw new ElementoNaoExistenteException();
        }
    }

    public List<Usuario> listar() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        for (Usuario usuario:usuarios) {
            listaUsuarios.add(usuario);
        }
        return listaUsuarios;
    }

    private int procurarIndice(Usuario U) {
        String verificacaoEmail = U.getEmail();
        for (int i = 0; i < this.usuarios.size(); i++) {
            if (verificacaoEmail.equals(this.usuarios.get(i).getEmail())) {
                return i;
            }
        }
        return -1;
    }
}
