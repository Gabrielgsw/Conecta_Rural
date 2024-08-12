package com.conectarural.conecta_rural.dados;
import com.conectarural.conecta_rural.Models.Vaga;

import java.util.ArrayList;
import java.util.List;

public class VagasRepository implements IRepository<Vaga> {

    public List<Vaga> listaDeVagas;

    public VagasRepository() {
        this.listaDeVagas = new ArrayList<>();
    }


    public void adicionar(Vaga v) {

        boolean existe = listaDeVagas.contains(v);
        //verifica se a vaga ja existe na lista

        if(!existe){
            listaDeVagas.add(v);
        }
        else{
            //VagaJaExistenteException
        }

    }


    public List<Vaga> listar() {

        List<Vaga> vagas = new ArrayList<>();

        for(Vaga vaga : listaDeVagas){
            vagas.add(vaga);
        }

        return vagas;
    }


    public void remover(Vaga v) {

        boolean existe = false;

        for(Vaga vaga : listaDeVagas){

            if(v.getCodigoVaga() == vaga.getCodigoVaga()) {

                existe = true;

            }
        }

        if(existe){
            listaDeVagas.remove(v);
        }
        else{
            //VagaNaoExistenteException
        }

    }


    public void atualizar(Vaga antigo, Vaga novo) {

        if (antigo.getCodigoVaga() == novo.getCodigoVaga()) {
            //as duas vagas sao iguais

            boolean antigoExiste = listaDeVagas.contains(antigo);
            //verifica se a vaga antiga esta na lista

            if (antigoExiste) {

                for (Vaga vaga : listaDeVagas) {
                    if (vaga.getCodigoVaga() == antigo.getCodigoVaga()) {
                        vaga = novo;
                        //substitui a vaga antiga pela nova
                    }
                }

            }
            else{

                //VagaNaoExistenteException

            }
        } else {

            //as duas vagas nao sao iguais, levantar exception

        }

    }

}
