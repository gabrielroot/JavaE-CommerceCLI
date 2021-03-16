/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.modelo;
import java.time.LocalDateTime;
/**
 *
 * @author gabriel
 */
public class Comentario {
    private int id;
    private String titulo;
    private String mensagem;
    private LocalDateTime data;

//    
    //COMO FAZER UM RELACIONAMENTO N-N?  
//    
    
    public Comentario(String titulo, String mensagem) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.data = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
