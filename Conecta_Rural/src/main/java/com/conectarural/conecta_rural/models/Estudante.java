package com.conectarural.conecta_rural.models;

import java.time.LocalDate;
import java.util.Objects;

public class Estudante extends Usuario {
    private String cpf;
    private LocalDate dataNascimento;
    private Curriculo curriculoEstudante;
    private Curso curso;
    private String periodoAtual;




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

    public Estudante(String nome, String email, String telefone, String endereco, String senha,String cpf, LocalDate dataNascimento,Curso curso, String periodo, Curriculo curriculoEstudante) {
        super(nome, email, telefone, endereco, senha);
        this.cpf = cpf;
        this.curso=curso;
        this.dataNascimento = dataNascimento;
        this.periodoAtual=periodo;
        this.curriculoEstudante=curriculoEstudante;
    }




    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public LocalDate getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento  = dataNascimento; }

    public Curriculo getCurriculoEstudante() { return curriculoEstudante; }

    public void setCurriculoEstudante(Curriculo curriculoEstudante) { this.curriculoEstudante = curriculoEstudante; }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getPeriodoAtual() {
        return periodoAtual;
    }

    public void setPeriodoAtual(Integer periodoAtual) {
        this.periodoAtual = String.valueOf(periodoAtual);
    }


    public void setPeriodoAtual(String periodoAtual) {
        this.periodoAtual = periodoAtual;
    }



    @Override
    public String toString() {
        return "Usuario{" +
                "cpf='" + cpf + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", curriculoEstudante=" + curriculoEstudante +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudante estudante)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(cpf, estudante.cpf);
    }

}
