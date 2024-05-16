package com.fiap;

import java.time.LocalDate;

public class CartaoDeCredito {
    private String nmCartao;
    private String nrCartao;
    private LocalDate dtExpiracao;
    private int nrSeguranca;
    private String apelido;
    private int cdUsuario;
 
    public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public CartaoDeCredito() {
    	
    }
    
    public CartaoDeCredito(String nmCartao, String nrCartao, LocalDate dtExpiracao, int nrSeguranca, String apelido, int cdUsuario) {
        this.nmCartao = nmCartao;
        this.nrCartao = nrCartao;
        this.dtExpiracao = dtExpiracao;
        this.nrSeguranca = nrSeguranca;
        this.apelido = apelido;
        this.cdUsuario = cdUsuario;
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