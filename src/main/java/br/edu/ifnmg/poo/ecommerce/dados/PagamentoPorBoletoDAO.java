/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.dados;

import br.edu.ifnmg.poo.ecommerce.modelo.PagamentoPorBoleto;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class PagamentoPorBoletoDAO {
    private static ArrayList<PagamentoPorBoleto> pagamentoPorBoletos = new ArrayList<>();
    private static int genId = 0;
    
    public static ArrayList<PagamentoPorBoleto> listarPagamentoPorBoletos(){
        return pagamentoPorBoletos;
    }
    
    public static void adicionarPagamentoPorBoleto(PagamentoPorBoleto pagamentoPorBoleto){
        pagamentoPorBoleto.setId(genId);
        pagamentoPorBoletos.add(pagamentoPorBoleto);
        genId ++;
    }
    
    public static PagamentoPorBoleto buscarPagamentoPorBoleto(int id) {
        PagamentoPorBoleto encontrado = null;
        for(PagamentoPorBoleto pagamentoPorBoleto : pagamentoPorBoletos){
            if(pagamentoPorBoleto.getId() == id){
                encontrado = pagamentoPorBoleto;
                break;
            }
        }
        
        return encontrado;
    }
    
    public static boolean editarPagamentoPorBoleto(int id, PagamentoPorBoleto prod) {
        for(PagamentoPorBoleto pagamentoPorBoleto : pagamentoPorBoletos){
            if(pagamentoPorBoleto.getId() == id){
                pagamentoPorBoleto = prod;
                return true;
            }
        }
        return false;
    }
}
