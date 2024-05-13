package com.conectarural.conecta_rural.Models;

public enum RegimeContratacao {
    CLT("CLT"), Estagio("Estágio"), PessoaJuridica("Pessoa Jurídica"), Temporario("Temporário"), Freelancer("Freelancer");


    private String regimeContratacao;

    RegimeContratacao(String regimeContratacao) { this.regimeContratacao = regimeContratacao; }

    @Override
    public String toString() { return this.regimeContratacao; }

}
