/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.dados;

import br.edu.ifnmg.poo.ecommerce.modelo.PagamentoPorCartao;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class PagamentoPorCartaoDAO {
    private static ArrayList<PagamentoPorCartao> pagamentosPorCartao = new ArrayList<>();
    private static int genId = 0;
    
    public static ArrayList<PagamentoPorCartao> listarPagamentoPorCartaos(){
        return pagamentosPorCartao;
    }
    
    public static void adicionarPagamentoPorCartao(PagamentoPorCartao pagamentoPorCartao){
        pagamentoPorCartao.setId(genId);
        pagamentosPorCartao.add(pagamentoPorCartao);
        genId ++;
    }
    
    public static PagamentoPorCartao buscarPagamentoPorCartao(int id) {
        PagamentoPorCartao encontrado = null;
        for(PagamentoPorCartao pagamentoPorCartao : pagamentosPorCartao){
            if(pagamentoPorCartao.getId() == id){
                encontrado = pagamentoPorCartao;
                break;
            }
        }
        
        return encontrado;
    }
    
    public static boolean editarPagamentoPorCartao(int id, PagamentoPorCartao pag) {
        PagamentoPorCartao encontrado = null;
        for(PagamentoPorCartao pagamentoPorCartao : pagamentosPorCartao){
            if(pagamentoPorCartao.getId() == id){
                encontrado = pag;
                return true;
            }
        }
        
        return false;
    }
}
