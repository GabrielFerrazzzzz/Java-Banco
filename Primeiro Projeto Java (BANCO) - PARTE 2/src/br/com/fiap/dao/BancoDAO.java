package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import com.fiap.Banco;

public class BancoDAO {

	
	private Connection conexao;
	
	public BancoDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public void gravar(Banco banco) {
		
		String sql = "INSERT INTO T_SIP_BANCO (id_banco, cd_banco, nm_banco, nr_agencia, nr_conta, saldo, cd_usuario)"
				+ "VALUES (SQ_T_BANCO.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement ps = conexao.prepareStatement(sql)){	
			ps.setInt(1, banco.getNroBanco());
			ps.setString(2, banco.getNomeBanco());	
			ps.setInt(3, banco.getAgencia());
			ps.setString(4, banco.getConta());
			ps.setDouble(5, banco.getSaldo());
			ps.setInt(6, banco.getCdUsuario());
			
            ps.execute();

            System.out.println("Registro do Banco feito com Sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
			
    public void excluir(int idBanco) {
        String sql = "DELETE FROM T_SIP_BANCO WHERE id_banco = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, idBanco);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir banco: " + e.getMessage());
        }
    }
    
    public void atualizar(Banco banco) {
        String sql = "UPDATE T_SIP_BANCO SET "
                   + "saldo = ? "
                   + "WHERE id_banco = ?";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setDouble(1, banco.getSaldo());
            ps.setInt(2, banco.getIdBanco()); 

            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("Banco atualizado com sucesso.");
            } else {
                System.out.println("Nenhuma alteração realizada. Verifique o ID do banco.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar banco: " + e.getMessage());
        } catch (InputMismatchException i) {
        	System.err.println("Você colocou letras, deveria ser número:" + i.getMessage());
        }
    }
	
    public List<Banco> getAll() {
        List<Banco> list = new ArrayList<>();
        String sql = "SELECT * FROM T_SIP_BANCO ORDER BY id_banco";
        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Banco banco = new Banco();
                banco.setIdBanco(rs.getInt("id_banco")); 
                banco.setNroBanco(rs.getInt("cd_banco"));  
                banco.setNomeBanco(rs.getString("nm_banco"));  
                banco.setAgencia(rs.getInt("nr_agencia")); 
                banco.setConta(rs.getString("nr_conta"));  
                banco.setSaldo(rs.getDouble("saldo"));  
                banco.setCdUsuario(rs.getInt("cd_usuario")); 
                list.add(banco);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar bancos: " + e.getMessage());
        }
        return list;
    }

		
		public Banco BuscarCdBanco(int cd_banco) {
			
		String sql = "SELECT * FROM T_SIP_BANCO WHERE id_banco = ?";
		Banco banco = new Banco();
		
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, cd_banco);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				banco.setIdBanco(rs.getInt("id_banco"));
				banco.setNomeBanco(rs.getString("nm_banco"));
			
			}
        
			ps.close();
			conexao.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return banco;
		}
}

