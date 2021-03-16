/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.modelo;

/**
 *
 * @author gabriel
 */
public class EnderecoEntrega {
    public int id;
    public String nome;
    public String cep;
    public String estado;
    public String cidade;
    public String bairro;
    public String ruaAv;

    public EnderecoEntrega(String nome, String cep, String estado, String cidade, String bairro, String ruaAv) {
        this.nome = nome;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.ruaAv = ruaAv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRuaAv() {
        return ruaAv;
    }

    public void setRuaAv(String ruaAv) {
        this.ruaAv = ruaAv;
    }
    
    
}
