package com.conectarural.conecta_rural.dados;
import com.conectarural.conecta_rural.models.Vaga;
import com.conectarural.conecta_rural.exceptions.*;
import java.util.ArrayList;
import java.util.List;

public class VagasRepository implements IRepository<Vaga> {

    public List<Vaga> listaDeVagas;

    public VagasRepository() {
        this.listaDeVagas = new ArrayList<>();
    }


    public void adicionar(Vaga v) throws ElementoJaExistenteException {

        boolean existe = listaDeVagas.contains(v);
        //verifica se a vaga ja existe na lista

        if(!existe){
            listaDeVagas.add(v);
        }
        else{

            throw new ElementoJaExistenteException();
        }

    }


    public List<Vaga> listar() {

        List<Vaga> vagas = new ArrayList<>();

        for(Vaga vaga : listaDeVagas){
            vagas.add(vaga);
        }

        return vagas;
    }


    public void remover(Vaga v) throws ElementoNaoExistenteException {

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

            throw new ElementoNaoExistenteException();
        }

    }


    public void atualizar(Vaga antigo, Vaga novo) throws ElementoNaoExistenteException, ElementosNaoIguaisException {

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


                throw new ElementoNaoExistenteException();

            }
        } else {


            throw new ElementosNaoIguaisException();
        }

    }

}
