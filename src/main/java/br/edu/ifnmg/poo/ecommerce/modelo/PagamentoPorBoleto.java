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
public class PagamentoPorBoleto extends Pagamento{
    private int id;
    private String cpf;
    private double valor;
    private String codBarra;
    private LocalDateTime vencimento;
    private boolean pago;

    public PagamentoPorBoleto(String cpf, double valor, String codBarra, String nome) {
        super(nome);
        this.cpf = cpf;
        this.valor = valor;
        this.codBarra = codBarra;
        this.vencimento = java.time.LocalDateTime.now().plusDays(2);
        this.pago = false;
    }
    
    public boolean pagarBoleto(){
        this.pago = true;
        
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public LocalDateTime getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDateTime vencimento) {
        this.vencimento = vencimento;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
}
