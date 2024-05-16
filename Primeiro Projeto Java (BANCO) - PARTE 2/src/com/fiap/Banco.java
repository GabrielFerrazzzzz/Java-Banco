package com.fiap;

public class Banco {
    private int idBanco;
    private int nroBanco;
    private String nomeBanco;
    private int agencia;
    private String conta;
    private double saldo;
    protected int cdUsuario;

    public Banco() {
    }

    public Banco(int idBanco, int nroBanco, String nomeBanco, int agencia, String conta, double saldo, int cdUsuario) {
        this.idBanco = idBanco;
        this.nroBanco = nroBanco;
        this.nomeBanco = nomeBanco;
        this.agencia = agencia;
        this.conta = conta;
        this.saldo = saldo;
        this.cdUsuario = cdUsuario;
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
    

    public String toString() {
        return "Banco{" +
                "idConta=" + idBanco +
                ", cdBanco=" + nroBanco +
                ", nomeBanco='" + nomeBanco + '\'' +
                ", agencia=" + agencia +
                ", conta='" + conta + '\'' +
                ", saldo=" + saldo +
                ", cdUsuario=" + cdUsuario +
                '}';
    }

    // Getters e setters
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

    public String getConta() {
        return conta;
    }

    public void setConta(String string) {
        this.conta = string;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public int getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(int cdUsuario) {
        this.cdUsuario = cdUsuario;
    }
}
