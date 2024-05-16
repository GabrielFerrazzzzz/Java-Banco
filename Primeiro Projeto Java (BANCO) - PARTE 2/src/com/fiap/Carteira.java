package com.fiap;

 
public class Carteira {
    private double saldo = 0;	
    private int cdCarteira;
    private int cdUsuario;

    public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

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

	public int getCdCarteira() {
		return cdCarteira;
	}

	public void setCdCarteira(int cdCarteira) {
		this.cdCarteira = cdCarteira;
	}

	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

}
