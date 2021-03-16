/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.dados;

import br.edu.ifnmg.poo.ecommerce.modelo.Cliente;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class ClienteDAO {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static int genId = 0;
    
    public static ArrayList listarClientes(){
        return clientes;
    }
    
    public static void adicionarCliente(Cliente cliente) {
        cliente.setId(genId);
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
}
