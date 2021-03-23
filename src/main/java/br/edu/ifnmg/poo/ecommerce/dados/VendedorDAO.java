/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.dados;

import br.edu.ifnmg.poo.ecommerce.modelo.Produto;
import br.edu.ifnmg.poo.ecommerce.modelo.Vendedor;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class VendedorDAO {
    private static ArrayList<Vendedor> vendedores = new ArrayList<>();
    private static int genId = 0;
    
    public static ArrayList<Vendedor> listarVendedores(){
        return vendedores;
    }
    
    public static void adicionarVendedor(Vendedor vendedor){
        vendedor.setId(genId);
        vendedores.add(vendedor);
        genId++;
    }
    
    public static Vendedor buscarVendedor(int id){
        Vendedor encontrado = null;
        for(Vendedor vendedor : vendedores){
            if(vendedor.getId() == id){
                encontrado = vendedor;
                break;
            }
        }
        
        return encontrado;
    }
    
    public static boolean editarVendedor(int id, Vendedor vendedor){
        ProdutoDAO produtoDAO = new ProdutoDAO();
        for (Vendedor encontrado : vendedores) {
            if(encontrado.getId() == id){
                encontrado = vendedor;
                for(Produto produto:encontrado.getProdutos()){
                    if(!produtoDAO.listarProdutos().contains(produto)){
                        produtoDAO.adicionarProduto(produto);
                    }
                }
                return true;
            }
        }
        return false;
    }
}
