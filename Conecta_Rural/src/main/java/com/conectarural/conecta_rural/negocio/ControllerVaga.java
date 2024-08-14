package com.conectarural.conecta_rural.negocio;
import com.conectarural.conecta_rural.Exceptions.ElementoNaoExistenteException;
import com.conectarural.conecta_rural.Exceptions.ElementosNaoIguaisException;
import com.conectarural.conecta_rural.Exceptions.ElementoJaExistenteException;
import com.conectarural.conecta_rural.Models.StatusVaga;
import com.conectarural.conecta_rural.dados.VagasRepository;
import com.conectarural.conecta_rural.Models.Vaga;
import com.conectarural.conecta_rural.dados.IRepository;

import java.util.ArrayList;
import java.util.List;

public class ControllerVaga {

    private IRepository<Vaga> repositorioVaga;
    private Vaga vagaSelecionada;
    private static ControllerVaga instance;

    public ControllerVaga() {
        repositorioVaga = new VagasRepository();
    }

    public static ControllerVaga getInstance() {
        if (instance == null) {
            instance = new ControllerVaga();
        }
        return instance;
    }

    public void cadastrarVaga(Vaga vaga) throws ElementoJaExistenteException {

        repositorioVaga.adicionar(vaga);

    }

    public void excluirVaga(Vaga vaga) throws ElementoNaoExistenteException {
        repositorioVaga.remover(vaga);
    }

    public void atualizarVaga(Vaga vaga1,Vaga vaga2) throws ElementoNaoExistenteException, ElementosNaoIguaisException {
        repositorioVaga.atualizar(vaga1,vaga2);
    }

    public List<Vaga> listar(){
        return repositorioVaga.listar();
    }

    public List<Vaga> listarVagasAbertas(){

        List<Vaga> vagasAbertas = new ArrayList<Vaga>();

        for(Vaga vaga : repositorioVaga.listar()){
            if(vaga.getStatusVaga() == StatusVaga.Aberta){
                vagasAbertas.add(vaga);
            }
        }

        return vagasAbertas;
    }

    public List<Vaga> listarVagasEmAndamento(){

        List<Vaga> vagasEmAndamento = new ArrayList<Vaga>();

        for(Vaga vaga : repositorioVaga.listar()){
            if(vaga.getStatusVaga() == StatusVaga.EmAndamento){
                vagasEmAndamento.add(vaga);
            }
        }

        return vagasEmAndamento;

    }

    public List<Vaga> listarVagasFechadas(){

        List<Vaga> vagasFechadas = new ArrayList<Vaga>();

        for(Vaga vaga : repositorioVaga.listar()){
            if(vaga.getStatusVaga() == StatusVaga.Encerrada){
                vagasFechadas.add(vaga);
            }
        }

        return vagasFechadas;

    }

    public List<Vaga> listaDeVagas(){

        List<Vaga> vagasFechadas = new ArrayList<Vaga>();
        List<Vaga> vagasEmAndamento = new ArrayList<Vaga>();
        List<Vaga> vagasAbertas = new ArrayList<Vaga>();

        for(Vaga vaga : repositorioVaga.listar()){
            if(vaga.getStatusVaga() == StatusVaga.EmAndamento){
                vagasEmAndamento.add(vaga);
            }
            if(vaga.getStatusVaga() == StatusVaga.Aberta){
                vagasAbertas.add(vaga);
            }
            if(vaga.getStatusVaga() == StatusVaga.Encerrada){
                vagasFechadas.add(vaga);
            }
        }

        if(!vagasFechadas.isEmpty()){
            return vagasFechadas;
        }
        if(!vagasEmAndamento.isEmpty()){
            return vagasEmAndamento;
        }

        return vagasAbertas;

    }

    public Vaga getVagaSelecionada() {
        return vagaSelecionada;
    }

    public void setVagaSelecionada(Vaga vagaSelecionada) {
        this.vagaSelecionada = vagaSelecionada;
    }

}
