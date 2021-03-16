/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.apresentacao;

import br.edu.ifnmg.poo.ecommerce.controle.ClienteControlador;
import br.edu.ifnmg.poo.ecommerce.modelo.Cliente;
import br.edu.ifnmg.poo.ecommerce.modelo.Comentario;

/**
 *
 * @author gabriel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Logar()");
//        do {            
//            System.out.println("======== E-Commerce ========");
//            System.out.println("1 - Cadastros");
//            System.out.println("");
//        } while (true);
        Cliente cliente = new Cliente("nome", "email", "senha", "cpf");
        ClienteControlador clientes = new ClienteControlador();
        clientes.cadastrarCliente(cliente);
        
        
        for(Cliente row : clientes.listarClientes()){
            System.out.println(row.getNome());
            System.out.println(row.getEmail());
            System.out.println(row.getCpf());
        }
        
    }
    
}
