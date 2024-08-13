package com.conectarural.conecta_rural.Models;

public enum StatusVaga {
    Aberta("Aberta"),EmAndamento("Em andamento"), Encerrada("Encerrada");

    private String statusVaga;

    StatusVaga(String statusVaga){
        this.statusVaga = statusVaga;
    }

    @Override
    public String toString() {
        return this.statusVaga;
    }


    public String getStatusVaga() {
        return statusVaga;
    }

    public void setStatusVaga(String statusVaga) {
        this.statusVaga = statusVaga;
    }
}
