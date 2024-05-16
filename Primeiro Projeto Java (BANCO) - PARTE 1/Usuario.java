package com.fiap;

import java.time.LocalDate;

public class Usuario {

	protected String nomeCompleto;
	protected String nrCpf;
	protected String cdUsuario;

	private LocalDate dtAniversario;
	private String dsSexo;
	private String dsProfissao;
	private String dsEmail;
	private double vlSalario;


	private Endereco endereco ;
	private Telefone telefone;
	private Carteira carteira ;
	private CartaoDeCredito cartaoDeCredito ;
	private BancoConta banco ;


	public Usuario() {
		this.nomeCompleto = new String(new char[40]);
		this.dsProfissao = new String(new char[15]);
		this.dsEmail = new String(new char[40]);
		this.dsSexo = new String(new char[10]);
	}



	public void Incluir ( String cdUsuario , String nrCPF , String nomeCompleto , LocalDate dtAniversario , String dsSexo , String dsProfissao , String dsEmail , double vlSalario  ) {

		this.nomeCompleto = nomeCompleto;
		this.nrCpf = nrCPF ;
		this.cdUsuario = cdUsuario ;
		this.dtAniversario = dtAniversario;
		this.dsSexo = dsSexo;
		this.dsProfissao = dsProfissao;
		this.dsEmail = dsEmail;
		this.vlSalario = vlSalario;

	}

	//______________________________________________________________________________________


	public Usuario buscaUsuario(String nome) {
		System.out.println("Qual o nome do Usuario ?");
		if(this.nomeCompleto == nome) {
			System.out.println("Nome do Usuario: " + this.nomeCompleto);

		}else {

			System.out.println("Usuario não encontrado ! ");
		}
		return null;


	}

	//______________________________________________________________________________________

	public void cadastrarEndereco(Endereco endereco) {
		this.endereco =  endereco;

		System.out.println("Endereço cadastrado com sucesso!" + endereco);
	}

	public Endereco getEndereco() {
		return endereco;
	}


	//______________________________________________________________________________________

	public void cadastrarTelefone(Telefone telefone) {
		this.telefone = telefone;

	}

	public Telefone getTelefone() {
		return telefone;
	}

	//______________________________________________________________________________________


	public void cadastrarCarteira(Carteira carteira) {
		this.carteira = carteira;
	}

	public Carteira getCarteira() {
		return carteira;
	}

	//______________________________________________________________________________________

	public void cadastrarCartaoDeCredito(CartaoDeCredito cartaoDeCredito) {
		this.cartaoDeCredito = cartaoDeCredito ;
	}

	public CartaoDeCredito getCartaoDeCredito() {
		return cartaoDeCredito;
	}

	//______________________________________________________________________________________



	public void cadastrarBanco( BancoConta banco ) {
		this.banco = banco ;
	}

	public BancoConta getBanco() {
		return banco;
	}


	//______________________________________________________________________________________


	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getNrCPF() {
		return nrCpf;
	}
	public void setNrCPF(String nrCPF) {
		this.nrCpf = nrCPF;
	}
	public String getCdUsuario() {
		return cdUsuario;
	}
	public void setCdUsuario(String cdUsuario) {
		this.cdUsuario = cdUsuario; // WARNING
	}
	public LocalDate getDtAniversario() {
		return dtAniversario;
	}
	public void setDtAniversario(LocalDate dtAniversario) {
		this.dtAniversario = dtAniversario;
	}
	public String getDsSexo() {
		return dsSexo;
	}
	public void setDsSexo(String dsSexo) {
		this.dsSexo = dsSexo;
	}
	public String getDsProfissao() {
		return dsProfissao;
	}
	public void setDsProfissao(String dsProfissao) {
		this.dsProfissao = dsProfissao;
	}
	public double getVlSalario() {
		return vlSalario;
	}
	public void setVlSalario(double vlSalario) {
		this.vlSalario = vlSalario;
	}


}