package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static final String USUARIO = "RM553011";
    private static final String SENHA = "fiap24";

    public static Connection abrirConexao() {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            if (conexao != null) {
                System.out.println("Conexão estabelecida com sucesso.");
            }
        } catch (SQLException e) {
            System.err.println("Falha na conexão: " + e.getMessage());
        }
        return conexao;  // Retorna a conexão, que pode ser null se falhou
    }
}
