package br.edu.ifnmg.poo.ecommerce.controle;


import br.edu.ifnmg.poo.ecommerce.dados.PagamentoPorCartaoDAO;
import br.edu.ifnmg.poo.ecommerce.dados.ParcelaDAO;
import br.edu.ifnmg.poo.ecommerce.modelo.Compra;
import br.edu.ifnmg.poo.ecommerce.modelo.PagamentoPorCartao;
import br.edu.ifnmg.poo.ecommerce.modelo.Parcela;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class PagamentoPorCartaoControlador {
    public ArrayList<PagamentoPorCartao> listarPagamentoPorCartaos() {
        return PagamentoPorCartaoDAO.listarPagamentoPorCartaos();
    }

    public void cadastrarPagamentoPorCartao(PagamentoPorCartao pagamentoPorCartao){
        PagamentoPorCartaoDAO.adicionarPagamentoPorCartao(pagamentoPorCartao);
        
    }
    
    public PagamentoPorCartao buscarPagamentoPorCartao(int id) {
        return PagamentoPorCartaoDAO.buscarPagamentoPorCartao(id);
    }
    
    public boolean editarPagamentoPorCartao(int id, PagamentoPorCartao pagamentoPorCartao) {
        return PagamentoPorCartaoDAO.editarPagamentoPorCartao(id, pagamentoPorCartao);
    }
    
    public void parcelar(PagamentoPorCartao pagamentoPorCartao, Compra compra){
        ParcelaDAO parcelaDAO = new ParcelaDAO();
        LocalDateTime hoje = LocalDateTime.now();
        double valorParcela = compra.valorTotal()/pagamentoPorCartao.getNumeroParcelas();
        ArrayList<Parcela> parcelas = new ArrayList<>();
        
        for (int i = 0; i < pagamentoPorCartao.getNumeroParcelas(); i++) {
            hoje = hoje.plusDays(30);
            Parcela parcela = new Parcela(hoje, valorParcela);
            parcelaDAO.adicionarParcela(parcela);
            parcelas.add(parcela);
        }
        pagamentoPorCartao.setParcelas(parcelas);
    }
}
