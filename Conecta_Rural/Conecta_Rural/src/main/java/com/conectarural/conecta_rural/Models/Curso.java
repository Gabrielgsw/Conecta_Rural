package com.conectarural.conecta_rural.Models;

public enum Curso {

    CienciaDaComputacao("Ciências da Computação"), LicenciaturaEmComputacao("Licenciatura em Computação"), MedicinaVeterinaria("Medicina Veterinaria"), Gastronomia("Gastronomia"), CienciasBiologias("Ciências Biológicas"), LicenciaturaFisica("Licenciatura em Física"), LicenciaturaMatematica("Licenciatura em Matemática"), SistemasDeInformacao("Sistema de Informação");

    private String curso;

    Curso(String curso){
        this.curso = curso;
    }

    @Override
    public String toString() {
        return this.curso;
    }
}
