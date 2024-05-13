package com.conectarural.conecta_rural.Models;

import java.time.LocalDate;

public class Estudante {
    private Long cpf;
    private LocalDate dataNascimento;
    private Curriculo curriculoEstudante;

    public Estudante() {
    }

    public Estudante(Long cpf, LocalDate dataNascimento, Curriculo curriculoEstudante) {
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
