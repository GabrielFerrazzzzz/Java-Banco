package com.fiap;

public class ContaGeral {
    private int idConta;
    private int idBanco;
    private double txMensalidade;
    private String tipoConta;
    private double saldo;

    public ContaGeral(int idConta, int idBanco, double txMensalidade, String tipoConta) {
        this.idConta = idConta;
        this.idBanco = idBanco;
        this.txMensalidade = txMensalidade;
        this.tipoConta = tipoConta;
        this.saldo = 0.0;  // Inicializa o saldo como 0.0 por padrão
    }

    public ContaGeral() {
	}

	// Getters e Setters
    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public double getTxMensalidade() {
        return txMensalidade;
    }

    public void setTxMensalidade(double txMensalidade) {
        this.txMensalidade = txMensalidade;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
