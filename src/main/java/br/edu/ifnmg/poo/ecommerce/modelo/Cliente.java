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
public class Cliente extends Usuario{
    ArrayList<EnderecoEntrega> enderecosEntrega = new ArrayList<>();
    ArrayList<Produto> carrinho = new ArrayList<>();
    ArrayList<Compra> compras = new ArrayList<>();
    
    public Cliente(String nome, String email, String senha, String cpf) {
        super(nome, email, senha, cpf);
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }

    
    public ArrayList<EnderecoEntrega> getEnderecosEntrega() {
        return enderecosEntrega;
    }

    public void setEnderecosEntrega(ArrayList<EnderecoEntrega> enderecosEntrega) {
        this.enderecosEntrega = enderecosEntrega;
    }

    public ArrayList<Produto> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ArrayList<Produto> carrinho) {
        this.carrinho = carrinho;
    }
    
    
    
    public void novoEndereco(String nome, String cep, String estado, String cidade, String bairro, String ruaAv){
        EnderecoEntrega endereco = new EnderecoEntrega(nome, cep, estado, cidade, bairro, ruaAv);
        this.enderecosEntrega.add(endereco);
    }
}
