package com.conectarural.conecta_rural.Models;

import java.time.LocalDateTime;

public abstract class Atividade {

    private String nome;
    private String resumo;
    private String area;
    private String tecnologias;
    private LocalDateTime data;

    public Atividade(String nome, String resumo, String area, String tecnologias, LocalDateTime data) {
        this.nome = nome;
        this.resumo = resumo;
        this.area = area;
        this.tecnologias = tecnologias;
        this.data = data;
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

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
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
