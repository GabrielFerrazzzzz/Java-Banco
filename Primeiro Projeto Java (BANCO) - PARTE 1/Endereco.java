package com.fiap;

public class Endereco {
	
		private int cdEndereco;
		private String tipoEndereco;
		private int nrCep;
		private String nmRua;
		private String nmBairro;
		private String nmCidade;
		private String nmEstado;
		private int nrImovel;
		
		public Endereco() {
		}
		
		public Endereco(int cdEndereco, String nmRua, String nmBairro, String neCidade, String nmEstado) {
			
		this.tipoEndereco = new String(new char[10]);
		this.nmRua = new String(new char[15]);
		this.nmBairro = new String(new char[15]);
		this.nmCidade = new String(new char[15]);
		this.nmEstado = new String(new char[15]);

		}
		
		public Endereco(int cdEndereco, int nrCep, String nmRua, String nmBairro, String neCidade, String nmEstado, int nrImovel) {
			this.cdEndereco = cdEndereco;
			this.nrCep = nrCep;
			this.nmRua = nmRua;
			this.nmBairro = nmBairro;
		}
		
		public void incluirEndereco(int cdEndereco, int nrCep, String nmRua, String nmBairro, String neCidade, String nmEstado, int nrImovel) {
		this.cdEndereco = cdEndereco;
		this.nrCep = nrCep;
		this.nmRua = nmRua;
		this.nmBairro = nmBairro;
		}

		public int getCdEndereco() {
			return cdEndereco;
		}

		public void setCdEndereco(int cdEndereco) {
			this.cdEndereco = cdEndereco;
		}

		public String getTipoEndereco() {
			return tipoEndereco;
		}

		public void setTipoEndereco(String tipoEndereco) {
			this.tipoEndereco = tipoEndereco;
		}

		public int getNrCep() {
			return nrCep;
		}

		public void setNrCep(int nrCep) {
			this.nrCep = nrCep;
		}

		public String getNmRua() {
			return nmRua;
		}

		public void setNmRua(String nmRua) {
			this.nmRua = nmRua;
		}

		public String getNmBairro() {
			return nmBairro;
		}

		public void setNmBairro(String nmBairro) {
			this.nmBairro = nmBairro;
		}

		public String getNmCidade() {
			return nmCidade;
		}

		public void setNmCidade(String nmCidade) {
			this.nmCidade = nmCidade;
		}

		public String getNmEstado() {
			return nmEstado;
		}

		public void setNmEstado(String nmEstado) {
			this.nmEstado = nmEstado;
		}

		public int getNrImovel() {
			return nrImovel;
		}

		public void setNrImovel(int nrImovel) {
			this.nrImovel = nrImovel;
		}
}
		
		

