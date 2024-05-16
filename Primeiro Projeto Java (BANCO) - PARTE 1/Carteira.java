package com.fiap;

 
public class Carteira {
    private double saldo = 0;	

    public Carteira() {
    }

    public void receber(double valor) {
        saldo += valor;
    }

    public void retirar(double valor) {
        saldo -= valor;
    }

    public double getSaldo() {
        return saldo;
    }

}
