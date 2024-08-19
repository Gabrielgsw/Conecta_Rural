package com.conectarural.conecta_rural.models;

import java.util.List;

public class Empresa extends Usuario{

    private String cnpj;
    private Integer quantidadeFuncionarios;
    private String areaAtuacao;
    private String descricao;
    private List<Vaga> vagas;

    public Empresa() {
        super();

    }

    public Empresa(String nome, String email, Long telefone, String endereco, String senha, String cnpj, Integer quantidadeFuncionarios, String areaAtuacao, String descricao) {
        super(nome, email, telefone, endereco, senha);
        this.cnpj = cnpj;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.areaAtuacao = areaAtuacao;
        this.descricao = descricao;
    }

    public String getCnpj() { return cnpj; }

    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public Integer getQuantidadeFuncionarios() { return quantidadeFuncionarios; }

    public void setQuantidadeFuncionarios() { this.quantidadeFuncionarios = quantidadeFuncionarios; }

    public String getAreaAtuacao() { return areaAtuacao; }

    public void setAreaAtuacao() { this.areaAtuacao = areaAtuacao; }

    public String getDescricao() { return descricao; }

    public void setDescricao() { this.descricao = descricao; }

    @Override
    public String toString() {
        return "Empresa{" +
                "cnpj='" + cnpj + '\'' +
                ", quantidadeFuncionarios='" + quantidadeFuncionarios + '\'' +
                ", areaAtuacao=" + areaAtuacao +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}