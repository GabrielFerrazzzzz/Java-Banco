package com.fiap;


public class Telefone {
	private int CdTelefone;
    private int DDD;
    private int nrCompleto;
    private String tipo;
    private int cdUsuario;  
  
    public Telefone() {   	
    }
    
    public Telefone(int CdTelefone, int DDD, int nrCompleto, String tipo) {
    	this.CdTelefone = CdTelefone;
        this.DDD = DDD;
        this.nrCompleto = nrCompleto;
        this.tipo = tipo;
    }
 
    public int getDDD() {
        return DDD;
    }
 
    public void setDDD(int DDD) {
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

	public int getCdTelefone() {
		return CdTelefone;
	}

	public void setCdTelefone(int cdTelefone) {
		CdTelefone = cdTelefone;
	}

	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}
	
}

