package com.conectarural.conecta_rural.models;

import java.util.Objects;

public abstract class Usuario {

    private String nome;
    private String email;
    private Long telefone;
    private String endereco;
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, String email, Long telefone, String endereco, String senha){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email) && Objects.equals(telefone, usuario.telefone) && Objects.equals(endereco, usuario.endereco) && Objects.equals(senha, usuario.senha);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone=" + telefone +
                ", endereco='" + endereco + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
