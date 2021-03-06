/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.modelo;

import br.edu.ifnmg.poo.ecommerce.controle.AdminControlador;
import br.edu.ifnmg.poo.ecommerce.controle.ClienteControlador;
import br.edu.ifnmg.poo.ecommerce.controle.ProdutoControlador;
import br.edu.ifnmg.poo.ecommerce.controle.VendedorControlador;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class Admin extends Usuario{
    private int id;
    private ArrayList<Vendedor> vendedoresDeletados = new ArrayList();
    private ArrayList<Produto> produtosDeletados = new ArrayList();
    private ArrayList<Cliente> clientesDeletados = new ArrayList();

    public Admin(String nome, String email, String senha, String cpf) {
        super(nome, email, senha, cpf);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Admin addAdmin(Admin admin){
        AdminControlador adminControlador = new AdminControlador();
        adminControlador.cadastrarAdmin(admin);
        return admin;
    }
    
    public boolean deletarVendedor(int id){
        VendedorControlador vendedorControlador = new VendedorControlador();
        AdminControlador adminControlador = new AdminControlador();
        Vendedor vendedor = vendedorControlador.buscarVendedor(id);
        if(vendedor != null){
            vendedoresDeletados.add(vendedor);
            this.setVendedoresDeletados(vendedoresDeletados);
            adminControlador.editarAdmin(this.getId(), this);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean deletarProduto(int id){
        ProdutoControlador produtoControlador = new ProdutoControlador();
        AdminControlador adminControlador = new AdminControlador();
        Produto produto = produtoControlador.buscarProduto(id);
        if(produto != null){
            produtosDeletados.add(produto);
            this.setProdutosDeletados(produtosDeletados);
            adminControlador.editarAdmin(this.getId(), this);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean deletarCliente(int id){
        ClienteControlador clienteControlador = new ClienteControlador();
        AdminControlador adminControlador = new AdminControlador();
        Cliente cliente = clienteControlador.buscarCliente(id);
        if(cliente != null){
            clientesDeletados.add(cliente);
            this.setClientesDeletados(clientesDeletados);
            adminControlador.editarAdmin(this.getId(), this);
            return true;
        }else{
            return false;
        }
    }
    
    public ArrayList<Vendedor> getVendedoresDeletados() {
        return vendedoresDeletados;
    }

    public void setVendedoresDeletados(ArrayList<Vendedor> vendedoresDeletados) {
        VendedorControlador vendedorControlador = new VendedorControlador();
        for(Vendedor vendedor : vendedoresDeletados){
            vendedorControlador.removerVendedor(vendedor);
        }
        this.vendedoresDeletados = vendedoresDeletados;
    }

    public ArrayList<Produto> getProdutosDeletados() {
        return produtosDeletados;
    }

    public void setProdutosDeletados(ArrayList<Produto> produtosDeletados) {
        ProdutoControlador produtoControlador = new ProdutoControlador();
        for(Produto produto : produtosDeletados){
            produtoControlador.removerProduto(produto);
        }
        this.produtosDeletados = produtosDeletados;
    }

    public ArrayList<Cliente> getClientesDeletados() {
        return clientesDeletados;
    }

    public void setClientesDeletados(ArrayList<Cliente> clientesDeletados) {
        ClienteControlador clienteControlador = new ClienteControlador();
        for(Cliente cliente : clientesDeletados){
            clienteControlador.removerCliente(cliente);
        }
        this.clientesDeletados = clientesDeletados;
    }
    
}
