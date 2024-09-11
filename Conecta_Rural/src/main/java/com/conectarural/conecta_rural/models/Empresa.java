package com.conectarural.conecta_rural.models;

import java.util.List;

public class Empresa extends Usuario{

    private String cnpj;
    private String quantidadeFuncionarios;
    private String areaAtuacao;
    private String descricao;
    private List<Vaga> vagas;

    public Empresa() {
        super();

    }

    /*public Empresa(String nome, String email, String telefone, String endereco, String senha, String cnpj, String quantidadeFuncionarios, String areaAtuacao, String descricao) {
        super(nome, email, telefone, endereco, senha);
        this.cnpj = cnpj;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.areaAtuacao = areaAtuacao;
        this.descricao = descricao;
    }*/

    //construtor para cadastro
    public Empresa(String nome, String email, String telefone, String endereco, String senha,String cnpj, String quantidadeFuncionarios, String areaAtuacao, String descricao) {
        super(nome, email, telefone, endereco, senha);
        this.cnpj=cnpj;
        this.quantidadeFuncionarios = quantidadeFuncionarios;  //teste
        this.areaAtuacao = areaAtuacao;  //teste
        this.descricao = descricao;  //teste
    }

    public String getCnpj() { return cnpj; }

    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getQuantidadeFuncionarios() { return quantidadeFuncionarios; }

    public void setQuantidadeFuncionarios(String quantidadeFuncionarios) { this.quantidadeFuncionarios = quantidadeFuncionarios; }

    public String getAreaAtuacao() { return areaAtuacao; }

    public void setAreaAtuacao(String areaAtuacao) { this.areaAtuacao = areaAtuacao; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

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