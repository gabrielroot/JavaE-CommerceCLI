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
    
    public Cliente(String nome, String email, String senha, String cpf) {
        super(nome, email, senha, cpf);
    }
    
    public void novoEndereco(String nome, String cep, String estado, String cidade, String bairro, String ruaAv){
        EnderecoEntrega endereco = new EnderecoEntrega(nome, cep, estado, cidade, bairro, ruaAv);
        this.enderecosEntrega.add(endereco);
    }
    
//    public void addItemCarrinho(int id){
//   
//    Produto produto = new Produto(nome, descricao, estoque, preco, categoria);
//        this.produtos.add(produto);
//    }
    
    
}