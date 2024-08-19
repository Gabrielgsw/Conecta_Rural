package com.conectarural.conecta_rural.models;

import java.time.LocalDate;

public class Estudante extends Usuario {
    private Long cpf;
    private LocalDate dataNascimento;
    private Curriculo curriculoEstudante;

    public Estudante() {
        super();
    }

    public Estudante(String nome, String email, Long telefone, String endereco, String senha, Long cpf, LocalDate dataNascimento, Curriculo curriculoEstudante) {
        super(nome, email, telefone, endereco, senha);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.curriculoEstudante = curriculoEstudante;
    }

    public Long getCpf() { return cpf; }

    public void setCpf(Long cpf) { this.cpf = cpf; }

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
