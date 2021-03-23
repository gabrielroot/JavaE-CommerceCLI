/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.dados;

import br.edu.ifnmg.poo.ecommerce.controle.ProdutoControlador;
import br.edu.ifnmg.poo.ecommerce.modelo.Comentario;
import br.edu.ifnmg.poo.ecommerce.modelo.Produto;
import br.edu.ifnmg.poo.ecommerce.modelo.Usuario;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class ComentarioDAO {
    private static ArrayList<Comentario> comentarios = new ArrayList<>();
    private static int genId = 0;

    public static ArrayList<Comentario> listarComentarios(){
        return comentarios;
    }
    
    public static void adicionarComentario(Comentario comentario){
        comentario.setId(genId);
        comentarios.add(comentario);
        genId ++;
    }
    
    public static boolean editarComentario(Comentario coment) {
        for(Comentario comentario : comentarios){
            if(comentario.equals(coment)){
                comentario = coment;
                return true;
            }
        }
        
        return false;
    }
    
    public static ArrayList<Comentario> buscarComentariosPorProduto(Produto produto){
        ArrayList<Comentario> coments = new ArrayList<>();
        for(Comentario coment:comentarios){
            if(coment.getProduto().equals(produto)){
                coments.add(coment);
            }
        }
        return coments;
    }
    
    public static ArrayList<Comentario> buscarComentariosPorUsuario(Usuario usuario){
        ArrayList<Comentario> coments = new ArrayList<>();
        for(Comentario coment:comentarios){
            if(coment.getUsuario().equals(usuario)){
                coments.add(coment);
            }
        }
        return coments;
    }
}
