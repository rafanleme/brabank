package br.com.senai.cursoandroid.brabank.model.entity;

public class Usuario {

    public Integer id;
    public String nome, cpf, email, senha, sexo;

    public Usuario(Integer id, String nome, String cpf, String email, String senha, String sexo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.sexo = sexo;
    }

    public Usuario() {

    }
}
