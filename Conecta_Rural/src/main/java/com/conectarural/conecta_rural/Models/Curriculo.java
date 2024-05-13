package com.conectarural.conecta_rural.Models;

public class Curriculo {

    private String Resumo;
    private Integer periodoAtual;


    public Curriculo(){
    }

    public String getResumo() {
        return Resumo;
    }

    public void setResumo(String resumo) {
        Resumo = resumo;
    }

    public Integer getPeriodoAtual() {
        return periodoAtual;
    }

    public void setPeriodoAtual(Integer periodoAtual) {
        this.periodoAtual = periodoAtual;
    }

    @Override
    public String toString() {
        return "Curriculo{" +
                "Resumo='" + Resumo + '\'' +
                ", periodoAtual=" + periodoAtual +
                '}';
    }
}
