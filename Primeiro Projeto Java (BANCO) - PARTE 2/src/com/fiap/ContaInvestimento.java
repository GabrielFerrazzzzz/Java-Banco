package com.fiap;

public class ContaInvestimento {
    private String idInvestimento;
    private int idBanco;
    private double saldoInvestido;
    private double taxaRendimento;
    private String tipoInvestimento;

    public ContaInvestimento(String idInvestimento, int idBanco, double saldoInvestido, double taxaRendimento, String tipoInvestimento) {
        this.idInvestimento = idInvestimento;
        this.idBanco = idBanco;
        this.saldoInvestido = saldoInvestido;
        this.taxaRendimento = taxaRendimento;
        this.tipoInvestimento = tipoInvestimento;
    }

    public ContaInvestimento() {
	}

	// Getters and Setters
    public String getIdInvestimento() {
        return idInvestimento;
    }

    public void setIdInvestimento(String idInvestimento) {
        this.idInvestimento = idInvestimento;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public double getSaldoInvestido() {
        return saldoInvestido;
    }

    public void setSaldoInvestido(double saldoInvestido) {
        this.saldoInvestido = saldoInvestido;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

	public String getTipoInvestimento() {
		return tipoInvestimento;
	}

	public void setTipoInvestimento(String tipoInvestimento) {
		this.tipoInvestimento = tipoInvestimento;
	}
}
