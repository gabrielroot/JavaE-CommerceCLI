/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.dados;

import br.edu.ifnmg.poo.ecommerce.modelo.Parcela;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class ParcelaDAO {
    private static ArrayList<Parcela> parcelas = new ArrayList<>();
    private static int genId = 0;
    
    public static ArrayList<Parcela> listarParcelas(){
        return parcelas;
    }
    
    public static void adicionarParcela(Parcela parcela){
        parcela.setId(genId);
        parcelas.add(parcela);
        genId ++;
    }
    
    public static Parcela buscarParcela(int id) {
        Parcela encontrado = null;
        for(Parcela parcela : parcelas){
            if(parcela.getId() == id){
                encontrado = parcela;
                break;
            }
        }
        
        return encontrado;
    }
    public static boolean editarParcela(int id, Parcela parcel) {
        Parcela encontrado = null;
        for(Parcela parcela : parcelas){
            if(parcela.getId() == id){
                encontrado = parcel;
                return true;
            }
        }
        
        return false;
    }
}
