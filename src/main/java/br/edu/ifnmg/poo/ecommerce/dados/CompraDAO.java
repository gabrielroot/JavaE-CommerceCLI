/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.dados;

import br.edu.ifnmg.poo.ecommerce.modelo.Compra;
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
