/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.modelo;

import br.edu.ifnmg.poo.ecommerce.controle.VendedorControlador;
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
    
    public void addProduto(Produto produto){
        VendedorControlador vendedorControlador = new VendedorControlador();
        vendedorControlador.editarVendedor(this.getId(), this);
        this.produtos.add(produto);
    }
    
    public boolean sacar(double valor){
        if(this.saldo >= valor){
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public double getReputacao() {
        return reputacao;
    }

    public void setReputacao(double reputacao) {
        this.reputacao = reputacao;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
}
