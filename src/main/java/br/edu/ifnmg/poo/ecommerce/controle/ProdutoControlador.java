/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.controle;

import br.edu.ifnmg.poo.ecommerce.dados.ProdutoDAO;
import br.edu.ifnmg.poo.ecommerce.modelo.Produto;

/**
 *
 * @author gabriel
 */
public class ProdutoControlador {
    public void cadastrarProduto(Produto produto){
        ProdutoDAO.adicionarProduto(produto);
    }
    
    public Produto buscarCliente(int id) {
        return ProdutoDAO.buscarProduto(id);
    }
}
