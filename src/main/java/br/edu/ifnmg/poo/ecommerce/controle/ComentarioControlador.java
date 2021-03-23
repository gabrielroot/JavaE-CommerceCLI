/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.controle;

import br.edu.ifnmg.poo.ecommerce.dados.ComentarioDAO;
import br.edu.ifnmg.poo.ecommerce.modelo.Comentario;
import br.edu.ifnmg.poo.ecommerce.modelo.Produto;
import br.edu.ifnmg.poo.ecommerce.modelo.Usuario;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class ComentarioControlador {
    public ArrayList<Comentario> listarComentarios() {
        return ComentarioDAO.listarComentarios();
    }

    public void cadastrarComentario(Comentario comentario){
        ComentarioDAO.adicionarComentario(comentario);
    }
    
    public boolean editarComentario(Comentario comentario) {
        return ComentarioDAO.editarComentario(comentario);
    }
    
    public ArrayList<Comentario> buscarComentariosPorProduto(Produto produto){
        return ComentarioDAO.buscarComentariosPorProduto(produto);
    }
    
    public static ArrayList<Comentario> buscarComentariosPorUsuario(Usuario usuario){
        return ComentarioDAO.buscarComentariosPorUsuario(usuario);
    }
}
