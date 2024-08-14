package com.conectarural.conecta_rural.negocio;

import com.conectarural.conecta_rural.Exceptions.*;
import com.conectarural.conecta_rural.Models.Usuario;
import com.conectarural.conecta_rural.dados.IRepository;
import com.conectarural.conecta_rural.dados.UsuarioRepository;
import java.util.ArrayList;
import com.conectarural.conecta_rural.Models.*;
import java.util.List;

public class ControllerUsuario {

    private IRepository<Usuario> repositorioUsuario;
    //private Usuario usuarioAchado;
    private static ControllerUsuario instance;

    public ControllerUsuario() {
        //usuarioAchado = null;
        repositorioUsuario = new UsuarioRepository();
    }

    public static ControllerUsuario getInstance() {
        if (instance == null) {
            instance = new ControllerUsuario();
        }
        return instance;
    }

    public List<Estudante>listarEstudantes(){
        List<Estudante> estudantes = new ArrayList<>();
        for(Usuario u :listar()){
            if(u instanceof Estudante){
                estudantes.add((Estudante) u);
            }
        }
        return estudantes;
    }

    public List<Empresa>listarEmpresas(){
        List<Empresa> empresas = new ArrayList<>();
        for(Usuario u:listar()){
            if(u instanceof Empresa){
                empresas.add((Empresa) u);
            }
        }
        return empresas;
    }

    public void adicionar(Usuario u) throws ElementoJaExistenteException{
        repositorioUsuario.adicionar(u);
    }

    public void remover(Usuario u) throws ElementoNaoExistenteException {
        repositorioUsuario.remover(u);
    }

    public void atualizar(Usuario antigo,Usuario novo)throws ElementoNaoExistenteException, ElementosNaoIguaisException{
         repositorioUsuario.atualizar(antigo,novo);
    }

    public List<Usuario> listar() {
        return repositorioUsuario.listar();
    }

}
