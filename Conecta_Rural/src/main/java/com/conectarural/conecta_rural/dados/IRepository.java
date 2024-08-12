package com.conectarural.conecta_rural.dados;
import com.conectarural.conecta_rural.Models.Vaga;

import java.util.List;

public interface IRepository<T> {

    void adicionar(T t);

    List<T> listar();

    void remover(T t);

    void atualizar(T antigo, T novo);


}
