package com.conectarural.conecta_rural.dados;
import com.conectarural.conecta_rural.exceptions.*;
import java.util.List;

public interface IRepository<T> {

    void adicionar(T t) throws ElementoJaExistenteException;

    List<T> listar();

    void remover (T t) throws ElementoNaoExistenteException;

    void atualizar(T antigo, T novo) throws ElementoNaoExistenteException, ElementosNaoIguaisException;


    T recuperarVaga(Integer codigo) throws ElementoNaoExistenteException;
}
