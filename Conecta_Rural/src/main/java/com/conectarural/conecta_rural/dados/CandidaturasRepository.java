package com.conectarural.conecta_rural.dados;
import com.conectarural.conecta_rural.Exceptions.ElementoNaoExistenteException;
import com.conectarural.conecta_rural.Exceptions.ElementosNaoIguaisException;
import com.conectarural.conecta_rural.Models.Candidatura;
import java.util.List;
import java.util.ArrayList;


public abstract class CandidaturasRepository implements IRepository<Candidatura> {

    private List<Candidatura> listaDeCandidaturas;

    public CandidaturasRepository() {
        this.listaDeCandidaturas = new ArrayList<>();
    }


    public void adicionar(Candidatura c) throws ElementoNaoExistenteException {

        if (!listaDeCandidaturas.contains(c)) {
            listaDeCandidaturas.add(c);
        } else {
            throw new ElementoNaoExistenteException();
        }
    }

    public List<Candidatura> listar() {

        List<Candidatura> candidaturas = new ArrayList<>();

        for (Candidatura candidatura : listaDeCandidaturas) {
            candidaturas.add(candidatura);
        }
        return candidaturas;
    }

    public void remover(Candidatura c) throws ElementoNaoExistenteException {

        boolean existe = false;

        for (Candidatura candidatura : listaDeCandidaturas) {

            if (c.getCandidato() == candidatura.getCandidato()) {

                existe = true;

            }
        }

        if (existe) {
            listaDeCandidaturas.remove(c);
        } else {

            throw new ElementoNaoExistenteException();
        }

    }

    public void atualizar(Candidatura antigo, Candidatura novo) throws ElementoNaoExistenteException, ElementosNaoIguaisException {
        if(antigo.getCandidato().getCpf() == novo.getCandidato().getCpf()) {

            boolean existe = listaDeCandidaturas.contains(antigo);
            if(existe){
                for(Candidatura candidatura : listaDeCandidaturas){
                    candidatura = novo;
                }
            }else{
                throw new ElementoNaoExistenteException();
            }

        }else{
            throw new ElementosNaoIguaisException();
        }



    }

}