package com.conectarural.conecta_rural.models;

import java.util.ArrayList;
import java.util.List;

public class Vaga {

    private String nomeVaga;
    private String descricaoVaga;
    private int quantidadeCandidatos;
    private double remuneracao;
    private int quantidadeVagas;
    private Empresa empresa;
    private int codigoVaga;
    private List<Candidatura> candidaturas;
    private RegimeContratacao regimeContratacao;
    private StatusVaga statusVaga;

    public Vaga() {

    }

    public Vaga(String nomeVaga, String descricaoVaga, int quantidadeCandidatos, double remuneracao, int quantidadeVagas, Empresa empresa, int codigoVaga, RegimeContratacao regimeContratacao, StatusVaga statusVaga) {
        this.nomeVaga = nomeVaga;
        this.descricaoVaga = descricaoVaga;
        this.quantidadeCandidatos = quantidadeCandidatos;
        this.remuneracao = remuneracao;
        this.quantidadeVagas = quantidadeVagas;
        this.empresa = empresa;
        this.codigoVaga = codigoVaga;
        this.regimeContratacao = regimeContratacao;
        this.statusVaga = statusVaga;
        this.candidaturas = new ArrayList<>();
    }

    public String getNomeVaga() { return nomeVaga; }

    public void setNomeVaga(String nomeVaga) { this.nomeVaga = nomeVaga; }

    public String getDescricaoVaga() { return descricaoVaga; }

    public void setDescricaoVaga(String descricaoVaga) { this.descricaoVaga = descricaoVaga; }

    public int getQuantidadeCandidatos() { return quantidadeCandidatos; }

    public void setQuantidadeCandidatos(int quantidadeCandidatos) { this.quantidadeCandidatos = quantidadeCandidatos; }

    public double getRemuneracao() { return remuneracao; }

    public void setRemuneracao(double remuneracao) { this.remuneracao = remuneracao; }

    public int getQuantidadeVagas() { return quantidadeVagas; }

    public void setQuantidadeVagas(int quantidadeVagas) { this.quantidadeVagas = quantidadeVagas; }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Empresa getEmpresa() { return empresa; }

    public void setEmpresa(String nomeEmpresa) { this.empresa = empresa; }

    public int getCodigoVaga() { return codigoVaga; }

    public void setCodigoVaga(int codigoVaga) { this.codigoVaga = codigoVaga; }

    public RegimeContratacao getRegimeContratacao() {
        return regimeContratacao;
    }

    public StatusVaga getStatusVaga() {
        return statusVaga;
    }

    public void setStatusVaga(StatusVaga statusVaga) {
        this.statusVaga = statusVaga;
    }

    public void setRegimeContratacao(RegimeContratacao regimeContratacao) {
        this.regimeContratacao = regimeContratacao;
    }

    public List<Candidatura> getCandidaturas() {
        return candidaturas;
    }

    public void setCandidaturas(List<Candidatura> candidaturas) {
        this.candidaturas = candidaturas;
    }

    @Override
    public String toString(){
        return "Vaga{" +
                "nomeVaga='" + nomeVaga + '\'' +
                ", descricaoVaga='" + descricaoVaga + '\'' +
                ", quantidadeCandidatos='" + quantidadeCandidatos + '\'' +
                ", remuneracao='" + remuneracao + '\'' +
                ", quantidadeVagas='" + quantidadeVagas + '\'' +
                ", nomeEmpresa='" + empresa + '\'' +
                ", codigoVaga='" + codigoVaga + '\'' +
                '}';
    }


    public boolean equals(Vaga o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return codigoVaga == ((Vaga) o).codigoVaga;
    }

}
