/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.modelo;

import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class Vendedor extends Usuario{
    double reputacao;
    double saldo;
    ArrayList<Produto> produtos = new ArrayList<>();
    
    public Vendedor(String nome, String email, String senha, String cpf) {
        super(nome, email, senha, cpf);
        this.saldo = 0;
        this.reputacao = 0;
    }
    
    public void addProduto(String nome, String descricao, int estoque, double preco, String categoria){
        Produto produto = new Produto(nome, descricao, estoque, preco, categoria);
        this.produtos.add(produto);
    }
    
    public boolean sacar(double valor){
        if(this.saldo >= valor){
            this.saldo -= valor;
            return true;
        }
        return false;
    }
}
