/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.dados;

import br.edu.ifnmg.poo.ecommerce.modelo.Admin;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class AdminDAO {
    private static ArrayList<Admin> admins = new ArrayList<>();
    private static int genId = 0;
    
    public static ArrayList<Admin> listarAdmins(){
        return admins;
    }
    
    public static void adicionarAdmin(Admin admin){
        admin.setId(genId);
        admins.add(admin);
        genId ++;
    }
    
    public static Admin buscarAdmin(int id) {
        Admin encontrado = null;
        for(Admin admin : admins){
            if(admin.getId() == id){
                encontrado = admin;
                break;
            }
        }
        
        return encontrado;
    }
    public static boolean editarAdmin(int id, Admin prod) {
        for(Admin admin : admins){
            if(admin.getId() == id){
                return true;
            }
        }
        
        return false;
    }
}
