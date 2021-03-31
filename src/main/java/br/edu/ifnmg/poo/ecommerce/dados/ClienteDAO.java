/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.dados;

import br.edu.ifnmg.poo.ecommerce.modelo.Cliente;
import br.edu.ifnmg.poo.ecommerce.modelo.EnderecoEntrega;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class ClienteDAO {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static int genId = 0;
    
    public static ArrayList listarClientes(){
        EnderecoEntregaDAO enderecos = new EnderecoEntregaDAO();
        return clientes;
    }
    
    public static void adicionarCliente(Cliente cliente, ArrayList<EnderecoEntrega> enderecos) {
        cliente.setId(genId);
        EnderecoEntregaDAO endereco = new EnderecoEntregaDAO();
        for(EnderecoEntrega end : enderecos){
            endereco.adicionarEndereco(end);
        }
        cliente.setEnderecosEntrega(enderecos);
        clientes.add(cliente);
        genId++;
    }
    
    public static Cliente buscarCliente(int id) {
        Cliente encontrado = null;
        for(Cliente cliente : clientes){
            if(cliente.getId() == id){
                encontrado = cliente;
                break;
            }
        }
        return encontrado;
    }
    
        public static boolean editarCliente(int id, Cliente client) {
        Cliente encontrado = null;
        for(Cliente cliente : clientes){
            if(cliente.getId() == id){
                encontrado = client;
                return true;
            }
        }
        return false;
    }
        
        public static boolean removerCliente(Cliente cliente){
        for(Cliente prod : clientes){
            if(cliente.equals(prod)){
                clientes.remove(cliente);
                return true;
            }
        }
        return false;
    }
}
