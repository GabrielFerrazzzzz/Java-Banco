package com.fiap;

import java.util.Scanner;

public class TesteFintech {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Usuario user = new Usuario();
		Carteira carteira = new Carteira();
		BancoConta bancoConta = new BancoConta();
		Endereco endereco = new Endereco();
		BancoContaPoupanca contaPoupanca = new BancoContaPoupanca();
		
		user.setNomeCompleto("Danilo Costa");	
		carteira.receber(5000);
		bancoConta.depositar(700);	
		contaPoupanca.depositar(900);
		contaPoupanca.retirar(500);
		contaPoupanca.setSaldo(1000);
		endereco.setNmBairro("Alphaville");
		
		
		
		
        System.out.print("Digite o número de dias que o saldo ficará rendendo: ");
        int dias = scanner.nextInt();
        double jurosAcumulados = contaPoupanca.calcularJuros(dias);
        double saldoAtualFinal = contaPoupanca.getSaldoFinal();
        
		
		System.out.println(user.getNomeCompleto());
		System.out.println(carteira.getSaldo());
		System.out.println(bancoConta.getSaldo());
		System.out.println(endereco.getNmBairro());
		System.out.println("Após " + dias + " dias, os juros acumulados serão: R$" + jurosAcumulados);
		System.out.println("Saldo atual final da conta poupança: " + saldoAtualFinal);
		


        scanner.close();
	}
	
 
}