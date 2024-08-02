package com.conectarural.conecta_rural.Models;

import java.time.LocalDateTime;

public class Projeto extends Atividade {

    private String link;

    public Projeto(String nome, String resumo, String area, String tecnologias, LocalDateTime data, String link) {
        super(nome, resumo, area, tecnologias, data);
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
