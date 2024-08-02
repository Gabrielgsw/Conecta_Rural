package com.conectarural.conecta_rural.Models;
import java.io.File;

public class Curriculo {

    private String resumo;
    private Integer periodoAtual;
    private File curriculoArquivo;
    private EstudanteProjeto projeto;
    private Curso curso;

    public Curriculo(){
    }
    
    public Curriculo(String resumo, Integer periodoAtual, EstudanteProjeto projeto,Curso curso){
        this.resumo = resumo;
        this.periodoAtual = periodoAtual;
        this.projeto = projeto;
        this.curso=curso;
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

    public EstudanteProjeto getProjeto() {
        return projeto;
    }

    public void setProjeto(EstudanteProjeto projeto){
        this.projeto = projeto;  
    }       
    
    public File getCurriculoArquivo() {
        return curriculoArquivo;
    }
    public void setCurriculoArquivo(File curriculoArquivo){

        this.curriculoArquivo = curriculoArquivo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Curriculo{" +
                "Resumo='" + resumo + '\'' +
                ", periodoAtual=" + periodoAtual +
                '}';
    }
}
