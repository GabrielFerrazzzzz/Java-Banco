package com.fiap;


public class Telefone {
    private byte DDD;
    private int nrCompleto;
    private String tipo;
  
    public Telefone() {   	
    }
    
    public Telefone(byte DDD, int nrCompleto, String tipo) {
        this.DDD = DDD;
        this.nrCompleto = nrCompleto;
        this.tipo = tipo;
    }
 
    public byte getDDD() {
        return DDD;
    }
 
    public void setDDD(byte DDD) {
        this.DDD = DDD;
    }
 
    public int getNrCompleto() {
        return nrCompleto;
    }
 
    public void setNrCompleto(int nrCompleto) {
        this.nrCompleto = nrCompleto;
    }

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}

