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
public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private int estoque;
    private double preco;
    private String categoria;
    private double avaliacao;

    public Produto(String nome, String descricao, int estoque, double preco, String categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.estoque = estoque;
        this.preco = preco;
        this.categoria = categoria;
        this.avaliacao = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
