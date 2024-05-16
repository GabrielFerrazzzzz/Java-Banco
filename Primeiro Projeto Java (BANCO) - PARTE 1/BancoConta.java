package com.fiap;

public class BancoConta {
    private int nroBanco;
    private String nomeBanco;
    private int agencia;
    private int conta;
    private double saldo;

    public BancoConta() {
    }

    public BancoConta(String nomeBanco, int agencia, int conta, int nroBanco) {
        this.nroBanco = nroBanco;
        this.nomeBanco = nomeBanco;
        this.agencia = agencia;
        this.conta = conta;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void retirar(double valor) {
        this.saldo -= valor;
    }

    public double verificarSaldo() {
        return saldo;
    }

    // Getters e setters para o atributo saldo
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNroBanco() {
        return nroBanco;
    }

    public void setNroBanco(int nroBanco) {
        this.nroBanco = nroBanco;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }
}
