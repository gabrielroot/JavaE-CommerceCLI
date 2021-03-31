/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.controle;

import br.edu.ifnmg.poo.ecommerce.dados.PagamentoPorBoletoDAO;
import br.edu.ifnmg.poo.ecommerce.modelo.PagamentoPorBoleto;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class PagamentoPorBoletoControlador {
        public ArrayList<PagamentoPorBoleto> listarPagamentoPorBoletos() {
        return PagamentoPorBoletoDAO.listarPagamentoPorBoletos();
    }

    public void cadastrarPagamentoPorBoleto(PagamentoPorBoleto produto){
        PagamentoPorBoletoDAO.adicionarPagamentoPorBoleto(produto);
    }
    
    public PagamentoPorBoleto buscarPagamentoPorBoleto(int id) {
        return PagamentoPorBoletoDAO.buscarPagamentoPorBoleto(id);
    }
    
    public boolean editarPagamentoPorBoleto(int id, PagamentoPorBoleto produto) {
        return PagamentoPorBoletoDAO.editarPagamentoPorBoleto(id, produto);
    }
}
