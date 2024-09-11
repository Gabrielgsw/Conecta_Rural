package com.conectarural.conecta_rural.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Projeto extends Atividade {

    private String link;

    public Projeto(String nome, String resumo, String area, String tecnologias, LocalDate data, LocalDate dataFim) {
        super(nome, resumo, area, tecnologias, data,dataFim);
        //this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
