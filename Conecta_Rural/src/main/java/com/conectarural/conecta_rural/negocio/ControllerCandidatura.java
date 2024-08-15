package com.conectarural.conecta_rural.negocio;

import com.conectarural.conecta_rural.Exceptions.*;

import com.conectarural.conecta_rural.Models.*;

import com.conectarural.conecta_rural.dados.CandidaturasRepository;

import com.conectarural.conecta_rural.dados.IRepository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class ControllerCandidatura {

    private IRepository<Candidatura> repositorioCandidatura;
    private Candidatura candidaturaRealizada;
    private static ControllerCandidatura instance;


    private ControllerCandidatura() { repositorioCandidatura = new CandidaturasRepository(); }

    public static ControllerCandidatura getInstance() {
        if (instance == null) {
            instance = new ControllerCandidatura();
        }
        return instance;
    }

    public List<Candidatura> candidaturasEstudantes(Estudante estudante) {
        List<Candidatura> candidaturas = new ArrayList<>();
        for(Candidatura c : repositorioCandidatura.listar()) {
            if(c.getCandidato().equals(estudante)) {
                candidaturas.add(c);
            }
        }
        return candidaturas;
    }

    public void candidatar(Estudante e, Vaga v) throws ElementoJaExistenteException {
        LocalDateTime dataCandidatura = LocalDateTime.now();
        Candidatura candidatura = new Candidatura(e, dataCandidatura, v);
        repositorioCandidatura.adicionar(candidatura);
    }

    public List<Candidatura> candidaturasPorVaga(Vaga v) throws ElementoJaExistenteException {
        List<Candidatura> candidaturas = new ArrayList<>();
        for(Candidatura c : repositorioCandidatura.listar()) {
            if(c.getVaga().equals(v)) {
                candidaturas.add(c);
            }
        }
        return candidaturas;
    }

    public List<Candidatura> candidaturasPorEmpresa(Empresa e){
        List<Candidatura> candidaturas = new ArrayList<>();
        for(Candidatura c: repositorioCandidatura.listar()){
            if(c.getVaga().getEmpresa().equals(e)){
                candidaturas.add(c);
            }
        }
        return candidaturas;
    }

    public List<Candidatura> estudanteJaCandidatado(Estudante e, Vaga v) throws ElementoJaExistenteException {
        List<Candidatura> candidaturas = new ArrayList<>();
        for(Candidatura c : candidaturasPorVaga(v)){
            if(c.getCandidato().equals(e)){
                candidaturas.add(c);
            }
        }
        return candidaturas;
    }

    public void adicionar(Candidatura c) throws ElementoJaExistenteException {
        repositorioCandidatura.adicionar(c);
    }

    public void remover(Candidatura c) throws ElementoNaoExistenteException {
        repositorioCandidatura.remover(c);
    }

    public void atualizar(Candidatura antigo, Candidatura novo) throws ElementoNaoExistenteException, ElementosNaoIguaisException {
        repositorioCandidatura.atualizar(antigo,novo);
    }

    public List<Candidatura> Listar() { return repositorioCandidatura.listar(); }
}

