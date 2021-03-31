/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.ecommerce.controle;

import br.edu.ifnmg.poo.ecommerce.dados.AdminDAO;
import br.edu.ifnmg.poo.ecommerce.modelo.Admin;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class AdminControlador {
        public ArrayList<Admin> listarAdmins() {
        return AdminDAO.listarAdmins();
    }

    public void cadastrarAdmin(Admin admin){
        AdminDAO.adicionarAdmin(admin);
    }
    
    public Admin buscarAdmin(int id) {
        return AdminDAO.buscarAdmin(id);
    }
    
    public boolean editarAdmin(int id, Admin admin) {
        return AdminDAO.editarAdmin(id, admin);
    }
}
