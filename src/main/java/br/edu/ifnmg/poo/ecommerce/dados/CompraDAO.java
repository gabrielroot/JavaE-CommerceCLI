/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.dados;

import br.edu.ifnmg.poo.ecommerce.controle.ProdutoControlador;
import br.edu.ifnmg.poo.ecommerce.modelo.Compra;
import br.edu.ifnmg.poo.ecommerce.modelo.Produto;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class CompraDAO {
    private static ArrayList<Compra> compras = new ArrayList<>();
    private static int genId = 0;
    
    public static ArrayList<Compra> listarCompras(){
        return compras;
    }
    
    public static void adicionarCompra(Compra compra){
        ProdutoControlador produtoControlador = new ProdutoControlador();
        for(Produto produtoComprado: compra.getProdutos()){
            Produto produto = produtoControlador.buscarProduto(produtoComprado.getId());
            produto.setEstoque(produto.getEstoque() - 1);
            produtoControlador.editarProduto(produto.getId(), produto);
        }
        compra.setId(genId);
        compras.add(compra);
        genId ++;
    }
    
    public static Compra buscarCompra(int id) {
        Compra encontrado = null;
        for(Compra compra : compras){
            if(compra.getId() == id){
                encontrado = compra;
                break;
            }
        }
        
        return encontrado;
    }
    public static boolean editarCompra(int id, Compra prod) {
        Compra encontrado = null;
        for(Compra compra : compras){
            if(compra.getId() == id){
                encontrado = prod;
                return true;
            }
        }
        
        return false;
    }
}
