package com.conectarural.conecta_rural.models;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Curriculo {

    private String resumo;
    private Integer periodoAtual;
    private File curriculoArquivo;
    private Curso curso;
    private String nomeCurso;
    public List<Atividade> atividades;

    public Curriculo(){
    }
    
    public Curriculo(String resumo, Integer periodoAtual,Curso curso){
        this.resumo = resumo;
        this.periodoAtual = periodoAtual;
        this.curso=curso;
        this.atividades = new ArrayList<>();
    }

    // Construtor alternativo
    public Curriculo(String resumo, Integer periodoAtual, String nomeCurso){
        this.resumo = resumo;
        this.periodoAtual = periodoAtual;
        this.nomeCurso = nomeCurso;
        this.atividades = new ArrayList<>();
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
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

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(Atividade a) {
        this.atividades.add(a);
    }

    @Override
    public String toString() {
        return "Curriculo{" +
                "Resumo='" + resumo + '\'' +
                ", periodoAtual=" + periodoAtual +
                '}';
    }
}
