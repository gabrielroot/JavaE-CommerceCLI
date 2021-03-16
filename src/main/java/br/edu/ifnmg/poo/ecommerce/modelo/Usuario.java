/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public abstract class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private ArrayList<Comentario> comentarios = new ArrayList<>();

    public Usuario(String nome, String email, String senha, String cpf) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public boolean login(String login, String senha){
        return login.equals(this.nome) && senha.contentEquals(this.senha);
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }
    
    public void comentar(String titulo, String mensagem){
        Comentario comentario = new Comentario(titulo, mensagem);
        this.comentarios.add(comentario);
    }
}
