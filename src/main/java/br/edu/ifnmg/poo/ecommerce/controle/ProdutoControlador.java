/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.controle;

import br.edu.ifnmg.poo.ecommerce.dados.ProdutoDAO;
import br.edu.ifnmg.poo.ecommerce.modelo.Produto;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class ProdutoControlador {
    public ArrayList<Produto> listarProdutos() {
        return ProdutoDAO.listarProdutos();
    }

    public void cadastrarProduto(Produto produto){
        ProdutoDAO.adicionarProduto(produto);
    }
    
    public Produto buscarProduto(int id) {
        return ProdutoDAO.buscarProduto(id);
    }
    
    public boolean editarProduto(int id, Produto produto) {
        return ProdutoDAO.editarProduto(id, produto);
    }
    
    public boolean removerProduto(Produto produto) {
        return ProdutoDAO.removerProduto(produto);
    }
}
