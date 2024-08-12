package com.conectarural.conecta_rural.dados;

import com.conectarural.conecta_rural.Models.Usuario;
import java.util.List;
import java.util.ArrayList;

public class UsuarioRepository implements IRepository<Usuario>{
    private List<Usuario> usuarios;


    //construtor público
    public UsuarioRepository(int tamanho){
        this.usuarios = new ArrayList<>();
    }

    //métodos da interface
    //adcionar
    public void adicionar(Usuario U) {
        this.usuarios.add(U);
        System.out.println("Um novo usuario chamado " + U.getNome() + " foi adicionado.");
    }


    //remover
    public void remover(Usuario U){
        int indice=procurarIndice(U);
        if(indice>=0){
            //remove o usuraios e realoca todos os outros
            this.usuarios.remove(indice);
            System.out.println("Conta removida." );
        }else{
            System.out.println("Essa conta não existe." );
        }
    }

    //atualizar
    public void atualizar(Usuario Antigo,Usuario Novo){
        int indice=procurarIndice(Antigo);

        if(indice>=0){
            this.usuarios.set(indice, Novo);
            System.out.println("O usuário "+Antigo.getNome()+" foi susbstituido pelo novo usuário"+ Novo.getNome());
        }else{
            System.out.println("Este usuário não existe." );
        }
    }

    // Implementação do método listar

    public List<Usuario> listar() {
        // Cria uma lista para retornar
        List<Usuario> listaUsuarios = new ArrayList<>();
        // Adiciona os usuários que já foram adicionados ao arrayList
        for (int i = 0; i < this.usuarios.size(); i++) {
            listaUsuarios.add(this.usuarios.get(i));
        }
        // Retorna a lista de usuários
        return listaUsuarios;
    }


    //método auxiliar de buscar índice de um obejto
    private int procurarIndice(Usuario U) {
        String verificacaoEmail = U.getEmail();

        for (int i = 0; i < this.usuarios.size(); i++) {
            if (verificacaoEmail.equals(this.usuarios.get(i).getEmail())) {
                return i;  // Retorna o índice assim que encontrar
            }
        }
        return -1;  // Retorna -1 se não encontrar o usuário
    }

}
