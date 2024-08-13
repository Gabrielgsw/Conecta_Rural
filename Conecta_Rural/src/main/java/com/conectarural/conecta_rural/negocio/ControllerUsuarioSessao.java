package com.conectarural.conecta_rural.negocio;

import com.conectarural.conecta_rural.Exceptions.FalhaLoginException;
import com.conectarural.conecta_rural.Models.*;
import com.conectarural.conecta_rural.dados.*;

import java.util.List;

public class ControllerUsuarioSessao {

    private IRepository<Usuario> repositorioUsuario;

    private Usuario usuarioLogado;
    private static ControllerUsuarioSessao instance;

    public ControllerUsuarioSessao() {
        usuarioLogado = null;
        repositorioUsuario = new UsuarioRepository();
    }

    public static ControllerUsuarioSessao getInstance() {
        if (instance == null) {
            instance = new ControllerUsuarioSessao();
        }
        return instance;
    }

    public void realizarLogin(String email, String senha) throws FalhaLoginException {
        ControllerUsuarioSessao controllerUsuarioSessao = ControllerUsuarioSessao.getInstance();
        Usuario user = null;
        for(Usuario u : controllerUsuarioSessao.listar()){
            if(email.equals(u.getEmail()) && senha.equals(u.getSenha())){
                user = u;
                System.out.println("teste usuário logado");

            }
        }

        if(user == null){
            throw new FalhaLoginException();
        }else{
            setUsuarioLogado(user);
        }

    }

    public List<Usuario> listar() {
        return repositorioUsuario.listar();
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }


}
