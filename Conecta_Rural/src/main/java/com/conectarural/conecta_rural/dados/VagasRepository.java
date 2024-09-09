package com.conectarural.conecta_rural.dados;
import com.conectarural.conecta_rural.models.Candidatura;
import com.conectarural.conecta_rural.models.Vaga;
import com.conectarural.conecta_rural.exceptions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

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


                        vaga.setCodigoVaga(novo.getCodigoVaga());
                        vaga.setNomeVaga(novo.getNomeVaga());
                        vaga.setDescricaoVaga(novo.getDescricaoVaga());
                        vaga.setEmpresa(novo.getEmpresa());
                        vaga.setStatusVaga(novo.getStatusVaga());
                        vaga.setRemuneracao(novo.getRemuneracao());
                        vaga.setRegimeContratacao(novo.getRegimeContratacao());
                        vaga.setQuantidadeCandidatos(novo.getQuantidadeCandidatos());
                        vaga.setQuantidadeVagas(novo.getQuantidadeVagas());
                        vaga.setEmpresa(novo.getEmpresa());

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

    public Vaga recuperarVaga(Integer codigo) throws ElementoNaoExistenteException {

        boolean existe = false;

        for(Vaga vaga : listaDeVagas){

            if(codigo == vaga.getCodigoVaga()) {

                return vaga;

            }
        }

        if(!existe){

            throw new ElementoNaoExistenteException();

        }

        return null;
    }

}
