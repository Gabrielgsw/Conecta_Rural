package com.conectarural.conecta_rural.models;
import java.time.LocalDateTime;
import java.util.Objects;

public class Candidatura {

    private Estudante candidato;
    private LocalDateTime dataCandidatura;
    private Vaga vaga;

    public Candidatura(Estudante candidato, LocalDateTime dataCandidatura, Vaga vaga) {
        this.candidato = candidato;
        this.dataCandidatura = dataCandidatura;
        this.vaga = vaga;
    }

    public Estudante getCandidato() {
        return candidato;
    }

    public void setCandidato(Estudante candidato) {
        this.candidato = candidato;
    }

    public LocalDateTime getDataCandidatura() {
        return dataCandidatura;
    }

    public void setDataCandidatura(LocalDateTime dataCandidatura) {
        this.dataCandidatura = LocalDateTime.now();
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }
    @Override
    public String toString(){
        return "Candidatura{" +
                "candidato='" + candidato + '\'' +
                ", dataCandidatura='" + dataCandidatura + '\'' +
                ", vaga='" + vaga + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidatura that)) return false;
        return Objects.equals(candidato, that.candidato) && Objects.equals(vaga, that.vaga);
    }

}
