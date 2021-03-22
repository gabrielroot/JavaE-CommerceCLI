/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.controle;

import br.edu.ifnmg.poo.ecommerce.dados.EnderecoEntregaDAO;
import br.edu.ifnmg.poo.ecommerce.modelo.EnderecoEntrega;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class EnderecoEntregaControlador {
    public static ArrayList<EnderecoEntrega> listarEnderecos(){
        return EnderecoEntregaDAO.listarEnderecos();
    }
    
    public void cadastrarEndereco(EnderecoEntrega endereco){
            EnderecoEntregaDAO.adicionarEndereco(endereco);
    }
    
    public EnderecoEntrega buscarEndereco(int id) {
        return EnderecoEntregaDAO.buscarEndereco(id);
    }
}
