package com.fiap;

public class BancoContaPoupanca extends BancoConta {
    private double saldoFinal;

    public BancoContaPoupanca(double saldoInicial) {
    	super.depositar(saldoInicial);
    }

    public BancoContaPoupanca() {
		// TODO Auto-generated constructor stub
	}

	// Método para calcular juros e atualizar o saldo final
    public double calcularJuros(int dias) {
        double taxaDiaria = 0.00016666666; // 0.1% de juros ao dia
        double juros = 0.0;
        for (int i = 0; i < dias; i++) {
            juros += getSaldo() * taxaDiaria;
        }
        saldoFinal = getSaldo() + juros;
        return juros;
    }

    // Método getter para o saldo final
    public double getSaldoFinal() {
        return saldoFinal;
    }

    // Método setter para o saldo final (opcional)
    public void setSaldoFinal(double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }
}
