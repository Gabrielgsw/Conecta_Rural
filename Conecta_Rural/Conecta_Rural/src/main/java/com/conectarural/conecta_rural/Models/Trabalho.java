package com.conectarural.conecta_rural.Models;

import java.time.LocalDateTime;

public class Trabalho extends Atividade{
    public Trabalho(String nome, String resumo, String area, String tecnologias, LocalDateTime data) {
        super(nome, resumo, area, tecnologias, data);
    }
}
