package com.conectarural.conecta_rural.models;

import java.util.Objects;

public class FiltroVaga {

    private Vaga vaga;
    private Estudante estudante;

    public FiltroVaga(Vaga vaga,Estudante estudante) {
        this.vaga = vaga;
        this.estudante = estudante;
    }

    public int filtrarVaga(Estudante estudante, Vaga vaga) {
        if((vaga.getStatusVaga() != StatusVaga.Aberta) || (vaga.getQuantidadeVagas() == 0)){
            return -1;
        }
        if((estudante.getCurriculoEstudante().getResumo() == null) || (estudante.getCurriculoEstudante().getCurso() == null)){
            return -1;
        }
        return 1;
    }


    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiltroVaga that = (FiltroVaga) o;
        return Objects.equals(vaga, that.vaga);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vaga);
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    @Override
    public String toString() {
        return "FiltroVaga{" +
                "vaga=" + vaga +
                '}';
    }
}
