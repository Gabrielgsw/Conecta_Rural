package com.conectarural.conecta_rural.models;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Curriculo {

    private String resumo;
    private Integer periodoAtual;
    private File curriculoArquivo;
    private Curso curso;
    private List<Atividade> atividades;

    public Curriculo(){
    }
    
    public Curriculo(String resumo, Integer periodoAtual,Curso curso){
        this.resumo = resumo;
        this.periodoAtual = periodoAtual;
        this.curso=curso;
        this.atividades = new ArrayList<>();
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
