/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.apresentacao;

import br.edu.ifnmg.poo.ecommerce.controle.ClienteControlador;
import br.edu.ifnmg.poo.ecommerce.modelo.Cliente;
import br.edu.ifnmg.poo.ecommerce.modelo.Comentario;
import br.edu.ifnmg.poo.ecommerce.modelo.EnderecoEntrega;
import br.edu.ifnmg.poo.ecommerce.dados.EnderecoEntregaDAO;
import java.util.ArrayList;

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

        Cliente cliente = new Cliente("nomeCLIENT", "emailCLIENT", "senhaCLIENT", "cpf");
//        EnderecoEntregaDAO enderecoDAO = new EnderecoEntregaDAO();
        EnderecoEntrega endereco01 = new EnderecoEntrega("nome", "cep", "estado", "cidade", "bairro", "ruaAv");
//        enderecoDAO.adicionarEndereco(endereco01);
        EnderecoEntrega endereco02 = new EnderecoEntrega("nome2", "cep2", "estado2", "cidade2", "bairro2", "ruaAv2");
//        enderecoDAO.adicionarEndereco(endereco02);
        
        
        ArrayList<EnderecoEntrega> enderecos = new ArrayList<>();
        enderecos.add(endereco01);
        enderecos.add(endereco02);
        
        ClienteControlador clientes = new ClienteControlador();
        clientes.cadastrarCliente(cliente, enderecos);
        
        
        for(Cliente row : clientes.listarClientes()){
            System.out.println(row.getId());
            System.out.println(row.getNome());
            System.out.println(row.getEmail());
            System.out.println(row.getCpf());
            
            for(EnderecoEntrega endereco : row.getEnderecosEntrega()){
                System.out.println("=====Endereços");
                System.out.println("    "+endereco.getId());
                System.out.println("    "+endereco.getNome());
                System.out.println("    "+endereco.getCep());
                System.out.println("    "+endereco.getEstado());
                System.out.println("    "+endereco.getCidade());
            }
        }
        
        System.out.println(clientes.buscarCliente(0).getNome());
        
    }
    
}
