package com.fiap;

public class BancoContaCorrente extends BancoConta {
    private double taxaManutencao;

    public BancoContaCorrente() {
        this.taxaManutencao = 10.0; // Definindo a taxa de manutenção como 10
    }

    public void aplicarTaxaManutencao() {
        if (getSaldo() >= taxaManutencao) {
            setSaldo(getSaldo() - taxaManutencao);
            System.out.println("Taxa de manutenção aplicada. Saldo atual: " + getSaldo());
        } else {
            System.out.println("Saldo insuficiente para aplicar taxa de manutenção.");
        }
    }

    public double getTaxaManutencao() {
        return taxaManutencao;
    }

    public void setTaxaManutencao(double taxaManutencao) {
        this.taxaManutencao = taxaManutencao;
    }
}
