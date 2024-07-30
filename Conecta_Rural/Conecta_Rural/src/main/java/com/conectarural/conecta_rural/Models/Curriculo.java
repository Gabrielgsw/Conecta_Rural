package com.conectarural.conecta_rural.Models;

public class Curriculo {

    private String resumo;
    private Integer periodoAtual;
    private File curriculoArquivo;
    private estudanteProjeto projeto;

    public Curriculo(){
    }
    
    public Curriculo(String resumo, Integer periodoAtual, estudanteProjeto projeto){
        this.resumo = resumo;
        this.periodoAtual = periodoAtual;
        this.projeto = projeto;
    }
    
    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Integer getPeriodoAtual() {
        return periodoAtual;
    }

    public void setPeriodoAtual(Integer periodoAtual) {
        this.periodoAtual = periodoAtual;
    }

    public estudanteProjeto getProjeto() {
        return projeto;
    }

    public void setProjeto(estudanteProjeto projeto){
        this.projeto = projeto;  
    }       
    
    public File getCurriculoArquivo() {
        return curriculoArquivo;
    }
    public void setCurriculoArquivo(File curriculoArquivo){
        this.curriculoArquivo = curriculoArquivo;
    }
    
    @Override
    public String toString() {
        return "Curriculo{" +
                "Resumo='" + resumo + '\'' +
                ", periodoAtual=" + periodoAtual +
                '}';
    }
}
