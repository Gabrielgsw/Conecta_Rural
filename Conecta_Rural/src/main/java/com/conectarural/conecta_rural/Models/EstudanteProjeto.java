package com.conectarural.conecta_rural.Models;

public class EstudanteProjeto {

    private String projetoNome;
    private String projetoDescricao;
    private String projetoLink;

    public EstudanteProjeto(){
    }

    public EstudanteProjeto(String NomeProjeto, String Projetodescricao, String Projetolink){
        this.projetoNome= NomeProjeto;
        this.projetoDescricao= Projetodescricao;
        this.projetoLink = Projetolink;
    }

    public String getProjetoNome() {
        return projetoNome;
    }

    public void setProjetoNome(String projetoNome) {
        this.projetoNome = projetoNome;
    }

    public String getProjetoDescricao() {
        return projetoDescricao;
    }

    public void setProjetoDescricao(String projetoDescricao) {
        this.projetoDescricao = projetoDescricao;
    }

    public String getProjetoLink() {
        return projetoLink;
    }

    public void setProjetoLink(String projetoLink) {
        this.projetoLink = projetoLink;
    }

    @Override
    public String toString() {
        return "estudanteProjeto{" +
                "projetoNome='" + projetoNome + '\'' +
                ", projetoDescricao='" + projetoDescricao + '\'' +
                ", projetoLink='" + projetoLink + '\'' +
                '}';
    }
}
