/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.dados;

import br.edu.ifnmg.poo.ecommerce.modelo.EnderecoEntrega;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class EnderecoEntregaDAO {
    private static ArrayList<EnderecoEntrega> enderecos = new ArrayList<>();
    private static int genId = 0;
    
    public ArrayList<EnderecoEntrega> listarEnderecos(){
        return enderecos;
    }
    
    public void cadastrarEndereco(EnderecoEntrega endereco){
        endereco.setId(genId);
        enderecos.add(endereco);
        genId++;
    }
    
    public static EnderecoEntrega buscarEndereco(int id){
        EnderecoEntrega encontrado = null;
        for(EnderecoEntrega endereco : enderecos){
            if(endereco.getId() == id){
                encontrado = endereco;
                break;
            }
        }
        
        return encontrado;
    }
}
