package com.fiap;

import java.time.LocalDate;

public class CartaoDeCredito {
    private String nmCartao;
    private String nrCartao;
    private LocalDate dtExpiracao;
    private int nrSeguranca;
 
    public CartaoDeCredito() {
    	
    }
    
    public CartaoDeCredito(String nmCartao, String nrCartao, LocalDate dtExpiracao, int nrSeguranca) {
        this.nmCartao = nmCartao;
        this.nrCartao = nrCartao;
        this.dtExpiracao = dtExpiracao;
        this.nrSeguranca = nrSeguranca;
    }
 
    public String getNmCartao() {
        return nmCartao;
    }
 
    public void setNmCartao(String nmCartao) {
        this.nmCartao = nmCartao;
    }
 
    public String getNrCartao() {
        return nrCartao;
    }
 
    public void setNrCartao(String nrCartao) {
        this.nrCartao = nrCartao;
    }
 
    public LocalDate getDtExpiracao() {
        return dtExpiracao;
    }
 
    public void setDtExpiracao(LocalDate dtExpiracao) {
        this.dtExpiracao = dtExpiracao;
    }
 
    public int getNrSeguranca() {
        return nrSeguranca;
    }
 
    public void setNrSeguranca(int nrSeguranca) {
        this.nrSeguranca = nrSeguranca;
    }
 
    public static void main(String[] args) {
 
    }
}