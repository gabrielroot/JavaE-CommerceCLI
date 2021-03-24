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
public class Compra {
    private Cliente cliente;
    private Pagamento pagamento;
    private int id;
    ArrayList<Produto> produtos = new ArrayList<>();

    public Compra(Pagamento pagamento, ArrayList<Produto> produtos, Cliente cliente) {
        this.pagamento = pagamento;
        this.produtos = produtos;
        this.cliente = cliente;
    }

    public double valorTotal(){
        double total = 0;
        for(Produto produto:produtos){
            total += produto.getPreco();
        }
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    
    
}
