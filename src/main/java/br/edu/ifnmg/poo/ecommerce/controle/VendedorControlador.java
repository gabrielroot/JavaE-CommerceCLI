/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.controle;

import br.edu.ifnmg.poo.ecommerce.dados.VendedorDAO;
import br.edu.ifnmg.poo.ecommerce.modelo.Produto;
import br.edu.ifnmg.poo.ecommerce.modelo.Vendedor;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class VendedorControlador {
    public static ArrayList<Vendedor> listarVendedores(){
        return VendedorDAO.listarVendedores();
    }
    
    public void cadastrarVendedor(Vendedor vendedor){
            VendedorDAO.adicionarVendedor(vendedor);
    }
    
    public Vendedor buscarVendedor(int id) {
        return VendedorDAO.buscarVendedor(id);
    }
    
    public Vendedor buscarVendedorPorProduto(Produto produto) {
        return VendedorDAO.buscarVendedorPorProduto(produto);
    }
    
    public boolean editarVendedor(int id, Vendedor vendedor) {
        return VendedorDAO.editarVendedor(id, vendedor);
    }
    
    public boolean removerVendedor(Vendedor vendedor) {
        return VendedorDAO.removerVendedor(vendedor);
    }
}
