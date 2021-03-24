/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.controle;

import br.edu.ifnmg.poo.ecommerce.dados.ParcelaDAO;
import br.edu.ifnmg.poo.ecommerce.modelo.Parcela;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class ParcelaControlador {
    public ArrayList<Parcela> listarParcelas() {
        return ParcelaDAO.listarParcelas();
    }

    public void cadastrarParcela(Parcela parcela){
        ParcelaDAO.adicionarParcela(parcela);
    }
    
    public Parcela buscarParcela(int id) {
        return ParcelaDAO.buscarParcela(id);
    }
    
    public boolean editarParcela(int id, Parcela parcela) {
        return ParcelaDAO.editarParcela(id, parcela);
    }
}
