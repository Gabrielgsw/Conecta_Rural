package com.conectarural.conecta_rural.models;

import java.time.LocalDate;

public class Estudante extends Usuario {
    private String cpf;
    private LocalDate dataNascimento;
    private Curriculo curriculoEstudante;


    public Estudante() {
        super();
    }

    public Estudante(String nome, String email, String telefone, String endereco, String senha, String cpf, LocalDate dataNascimento, Curriculo curriculoEstudante) {
        super(nome, email, telefone, endereco, senha);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.curriculoEstudante = curriculoEstudante;

    }

    //construtor para cadastro

    public Estudante(String nome, String email, String telefone, String endereco, String senha,String cpf) {
        super(nome, email, telefone, endereco, senha);
        this.cpf = cpf;
    }



    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public LocalDate getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento  = dataNascimento; }

    public Curriculo getCurriculoEstudante() { return curriculoEstudante; }

    public void setCurriculoEstudante(Curriculo curriculoEstudnate) { this.curriculoEstudante = curriculoEstudante; }

    @Override
    public String toString() {
        return "Usuario{" +
                "cpf='" + cpf + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", curriculoEstudante=" + curriculoEstudante +
                '}';
    }


}
