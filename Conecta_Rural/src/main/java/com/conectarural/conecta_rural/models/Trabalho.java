package com.conectarural.conecta_rural.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Trabalho extends Atividade{
    public Trabalho(String nome, String resumo, String area, String tecnologias, LocalDate data, LocalDate dataFim) {
        super(nome, resumo, area, tecnologias, data, dataFim);
    }
}
