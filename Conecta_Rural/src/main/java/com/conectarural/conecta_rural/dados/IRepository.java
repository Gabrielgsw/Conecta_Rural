package com.conectarural.conecta_rural.dados;
import com.conectarural.conecta_rural.Models.Vaga;
import com.conectarural.conecta_rural.Exceptions.*;
import java.util.List;

public interface IRepository<T> {

    void adicionar(T t) throws ElementoNaoExistenteException;

    List<T> listar();

    void remover (T t) throws ElementoNaoExistenteException;

    void atualizar(T antigo, T novo) throws ElementoNaoExistenteException, ElementosNaoIguaisException;


}
