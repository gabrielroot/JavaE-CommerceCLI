/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.controle;

import br.edu.ifnmg.poo.ecommerce.dados.CompraDAO;
import br.edu.ifnmg.poo.ecommerce.modelo.Compra;
import br.edu.ifnmg.poo.ecommerce.modelo.PagamentoPorBoleto;
import br.edu.ifnmg.poo.ecommerce.modelo.PagamentoPorCartao;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class CompraControlador {
    public ArrayList<Compra> listarCompras() {
        return CompraDAO.listarCompras();
    }

    public void cadastrarCompra(Compra compra){
        CompraDAO.adicionarCompra(compra);
        ClienteControlador clienteControlador = new ClienteControlador();
        compra.getCliente().getCompras().add(compra);
        compra.getCliente().setCompras(compra.getCliente().getCompras());
        clienteControlador.editarCliente(compra.getId(), compra.getCliente());
        if(compra.getPagamento() instanceof PagamentoPorCartao){
            System.out.println("Pagou via cartao");
            PagamentoPorCartaoControlador pagamentoPorCartaoControlador = new PagamentoPorCartaoControlador();
            PagamentoPorCartao pagamentoPorCartao = (PagamentoPorCartao) compra.getPagamento();
            pagamentoPorCartaoControlador.parcelar(pagamentoPorCartao, compra);
        }else if(compra.getPagamento() instanceof PagamentoPorBoleto){
            System.out.println("Pagou via boleto");
            PagamentoPorBoletoControlador pagamentoPorBoletoControlador = new PagamentoPorBoletoControlador();
            PagamentoPorBoleto pagamentoPorBoleto = (PagamentoPorBoleto) compra.getPagamento();
            pagamentoPorBoletoControlador.cadastrarPagamentoPorBoleto(pagamentoPorBoleto);
        }
    }
    
    public Compra buscarCompra(int id) {
        return CompraDAO.buscarCompra(id);
    }
    
    public boolean editarCompra(int id, Compra compra) {
        return CompraDAO.editarCompra(id, compra);
    }
}