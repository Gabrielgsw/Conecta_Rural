package com.conectarural.conecta_rural.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Atividade {

    private String nome;
    private String resumo;
    private String area;
    private String tecnologias;
    private LocalDate data;
    private LocalDate dataFinal;

    public Atividade(String nome, String resumo, String area, String tecnologias, LocalDate data, LocalDate dataFinal) {
        this.nome = nome;
        this.resumo = resumo;
        this.area = area;
        this.tecnologias = tecnologias;
        this.data = data;
        this.dataFinal = dataFinal;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(String tecnologias) {
        this.tecnologias = tecnologias;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Atividade{" +
                "Nome='" + nome + '\'' +
                "Área='" + area + '\'' +
                "Data='" + data + '\'' +
                "Tecnologias='" + tecnologias + '\'' +
                "Resumo'" + resumo + '\'' +
                '}';
    }
}
