/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.dados;

import br.edu.ifnmg.poo.ecommerce.modelo.Produto;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class ProdutoDAO {
    private static ArrayList<Produto> produtos = new ArrayList<>();
    private static int genId = 0;
    
    public static void adicionarProduto(Produto produto){
        produto.setId(genId);
        produtos.add(produto);
        genId ++;
    }
    
    public static Produto buscarProduto(int id) {
        Produto encontrado = null;
        for(Produto produto : produtos){
            if(produto.getId() == id){
                encontrado = produto;
            }
            break;
        }
        
        return encontrado;
    }
}
