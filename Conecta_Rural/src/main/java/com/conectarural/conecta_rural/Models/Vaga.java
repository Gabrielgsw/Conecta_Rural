package com.conectarural.conecta_rural.Models;

public class Vaga {

    private String nomeVaga;
    private String descricaoVaga;
    private int quantidadeCandidatos;
    private double remuneracao;
    private int quantidadeVagas;
    private Empresa empresa;
    private int codigoVaga;


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

    public Empresa getEmpresa() { return empresa; }

    public void setEmpresa(String nomeEmpresa) { this.empresa = empresa; }

    public int getCodigoVaga() { return codigoVaga; }

    public void setCodigoVaga(int codigoVaga) { this.codigoVaga = codigoVaga; }

    public RegimeContratacao getRegimeContratacao() {
        return regimeContratacao;
    }

    public void setRegimeContratacao(RegimeContratacao regimeContratacao) {
        this.regimeContratacao = regimeContratacao;
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



}
