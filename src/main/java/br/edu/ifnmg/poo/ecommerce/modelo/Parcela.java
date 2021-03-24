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
public class Parcela {
    private int id;
    private boolean paga;
    private LocalDateTime vencimento;
    private double valorParcela;

    public Parcela(LocalDateTime vencimento, double valorParcela) {
        this.paga = false;
        this.vencimento = vencimento;
        this.valorParcela = valorParcela;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    public LocalDateTime getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDateTime vencimento) {
        this.vencimento = vencimento;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }
    
    
}
