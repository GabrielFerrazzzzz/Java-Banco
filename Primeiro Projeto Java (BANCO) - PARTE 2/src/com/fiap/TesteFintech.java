package com.fiap;

/*
import java.util.Scanner;
import java.util.List;
import java.time.LocalDate;
import br.com.fiap.dao.BancoDAO;
import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.dao.Conexao;
import br.com.fiap.dao.UsuarioDAO;
*/

public class TesteFintech {


	public static void main(String[] args) {
		
		/*
    	Scanner scanner = new Scanner(System.in);
    	
    	
        UsuarioDAO usuarioDAO = new UsuarioDAO(Conexao.abrirConexao());
        Usuario usuario = new Usuario();	
        EnderecoDAO enderecoDAO = new EnderecoDAO(Conexao.abrirConexao());  
        Endereco endereco = new Endereco();
        BancoDAO bancoDAO = new BancoDAO(Conexao.abrirConexao());
        Banco banco = new Banco();
        
        
        // Métodos de GRAVAR
        
        //USUARIO
		usuario.setNomeCompleto("Pedro");
		usuario.setNrCPF("471.008.588-36");
		usuario.setDtAniversario(LocalDate.of(1980, 10, 3)); // Ano, Mês, Dia
		usuario.setDsSexo("M");
		usuario.setDsEmail("Joao123.@gmail.com");
		usuario.setDsProfissao("Programador");
		usuario.setVlSalario(2700.0);
		usuario.setSenha("Agiota");
		usuarioDAO.gravar(usuario); 
		
		//ENDERECO
        endereco.setTipoEndereco("CASA");
        endereco.setNrCep(344567888);
        endereco.setNmRua("Juscelino Kubitschek");
        endereco.setNmBairro("Alves Dias");
        endereco.setNmCidade("São Bernardo");
        endereco.setNmEstado("SP");
        endereco.setNrImovel(107);
        endereco.setCdUsuario(7);
		enderecoDAO.gravar(endereco); 
		
		//BANCO
		banco.setIdBanco(1);
		banco.setNroBanco(0);
		banco.setNomeBanco("Nubank");
		banco.setAgencia(0);
		banco.setConta("2355");
		banco.setSaldo(0);
		banco.setCdUsuario(0);
		bancoDAO.gravar(banco);
		
		
		// Método de EXCLUIR
		
		//USUARIO
		//usuarioDAO.excluir(111); // 	Excluir
		
		//ENDERECO
		//enderecoDAO.excluir(1); // Excluir
		
		//BANCO
		// bancoDAO.excluir(1); // Excluir

		// Método de ATUALIZAR
		/*
		//USUARIO
        System.out.print("Digite o ID do usuário: ");
        int id_usuario = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite a nova senha: ");
        String novaSenha = scanner.nextLine();
        usuario.setCdUsuario(id_usuario);
        usuario.setSenha(novaSenha);
        usuarioDAO.atualizar(usuario); 	
        
        //BANCO
        System.out.print("Digite o ID do banco para atualização: ");
        int id_banco = scanner.nextInt();
        System.out.print("Digite o novo saldo:");
        double novoSaldo = scanner.nextDouble();
        banco.setIdBanco(id_banco);
        banco.setSaldo(novoSaldo);
        bancoDAO.atualizar(banco); 
        
        
        //ENDERECO
        System.out.println("Digite o ID do úsuario: ");
        int id_user_endereco = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o CD de endereço: ");
        int cd_endereco = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o novo bairro: ");
        String novoBairro = scanner.nextLine();
        System.out.println("Digite a nova cidade: ");
        String novaCidade = scanner.nextLine();
        System.out.println("Digite o novo Estado: ");
        String novoEstado = scanner.nextLine();
        System.out.println("Qual o nome da nova rua: ");
        String novaRua = scanner.nextLine();
        System.out.println("Qual o número do novo cep: ");
        String novoCep = scanner.nextLine();
        System.out.println("Digite o novo número do imóvel: ");
        int novoImovel = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Qual seria o tipo de endereço: ");
        String novoTipoEndereco = scanner.nextLine();
        endereco.setTipoEndereco(novoTipoEndereco);
        endereco.setCdUsuario(id_user_endereco);
        endereco.setCdEndereco(cd_endereco);
        endereco.setNmBairro(novoBairro);
        endereco.setNmCidade(novaCidade);
        endereco.setNmEstado(novoEstado);
        endereco.setNmRua(novaRua);
        endereco.setNrCep(novoCep);
        endereco.setNrImovel(novoImovel);  
        enderecoDAO.atualizar(endereco);
        //ENDERECO
        
        
        
        // Método de LISTA (GetAll)
		
        //USUARIO
		List<Usuario> usuarios = usuarioDAO.getAll(); //Lista
		for(Usuario f: usuarios) {
			System.out.println(f);
		}
		System.out.println("");
		
		//ENDERECO
		List<Endereco> enderecos = enderecoDAO.getAll();
		for(Endereco f: enderecos) {
			System.out.println(f);
		}
		System.out.println("");
		
		//BANCO
        List<Banco> bancos = bancoDAO.getAll(); // Lista
        for (Banco f : bancos) {
            System.out.println(f); // Lista
        System.out.println("");  
		 
        scanner.close();
    	 */
	}
	}

