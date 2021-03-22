/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.controle;

import br.edu.ifnmg.poo.ecommerce.dados.ClienteDAO;
import br.edu.ifnmg.poo.ecommerce.modelo.Cliente;
import br.edu.ifnmg.poo.ecommerce.modelo.EnderecoEntrega;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class ClienteControlador {
    public ArrayList<Cliente> listarClientes(){
        return ClienteDAO.listarClientes();
    }
    
    public void cadastrarCliente(Cliente cliente, ArrayList<EnderecoEntrega> enderecos){
        cliente.setEnderecosEntrega(enderecos);
        ClienteDAO.adicionarCliente(cliente);
    }
    
    public Cliente buscarCliente(int id) {
        return ClienteDAO.buscarCliente(id);
    }
}
