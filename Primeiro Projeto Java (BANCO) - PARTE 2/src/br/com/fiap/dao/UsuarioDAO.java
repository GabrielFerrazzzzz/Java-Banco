package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.fiap.Banco;
import com.fiap.Usuario;

public class UsuarioDAO {

	
	private Connection conexao;
	
	public UsuarioDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public String gravar(Usuario usuario) {
		
		String sql = "INSERT INTO T_SIP_USUARIO (nm_user, cd_usuario, cpf, dt_nascimento, sexo, ds_email, ds_profissao, vl_salario, senha)"
				+ "VALUES (?, SQ_T_USUARIO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);	
			ps.setString(1, usuario.getNomeCompleto());
			ps.setString(2, usuario.getNrCPF());	
	        LocalDate localDate = usuario.getDtAniversario();
	        if (localDate != null) {
	            ps.setDate(3, java.sql.Date.valueOf(localDate));
	        } else {
	            ps.setDate(3, null);
	        }			ps.setString(4, usuario.getDsSexo());
			ps.setString(5, usuario.getDsEmail());
			ps.setString(6, usuario.getDsProfissao());
			ps.setDouble(7, usuario.getVlSalario());
			ps.setString(8, usuario.getSenha());
			
	        ps.execute();
	            
	        
	       ps.close();
	       conexao.close();
	       System.out.println("Registro do Usuario feito com Sucesso!");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public void excluir(int cdUsuario) {
		String sql = "DELETE FROM T_SIP_USUARIO WHERE cd_usuario = ?";
		try (PreparedStatement ps = conexao.prepareStatement(sql)) {
			ps.setInt(1,cdUsuario);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao excluir usuario" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void atualizar(Usuario usuario) {
		String sql = "UPDATE T_SIP_USUARIO SET " +
	                "nm_user = ?, " +
	                "dt_nascimento = ?, " +
	                "sexo = ?, " +
	                "ds_profissao = ?, " +
	                "vl_salario = ?, " +
	                "senha = ? " +
					"WHERE cd_usuario = ?";
		
	       try (PreparedStatement ps = conexao.prepareStatement(sql)) {
	            ps.setString(1, usuario.getNomeCompleto());
	            if (usuario.getDtAniversario() != null) {
	                ps.setDate(2, java.sql.Date.valueOf(usuario.getDtAniversario()));
	            } else {
	                ps.setDate(2, null);
	            }
	            ps.setString(3, usuario.getDsSexo());
	            ps.setString(4, usuario.getDsProfissao());
	            ps.setDouble(5, usuario.getVlSalario());
	            ps.setString(6, usuario.getSenha());
	            ps.setInt(7, usuario.getCdUsuario());

	            ps.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println("Erro ao atualizar o usuário: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	
	
	
	public List<Usuario> getAll() {
		
		String sql = "SELECT * FROM T_SIP_USUARIO ORDER BY cd_usuario";
		
		List<Usuario> list = new ArrayList<Usuario>();
		
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setCdUsuario(rs.getInt("cd_usuario"));
				usuario.setNomeCompleto(rs.getString("nm_user"));
				usuario.setNrCPF(rs.getString("cpf"));
				Date data = rs.getDate("dt_nascimento");
				usuario.setDtAniversario(data.toLocalDate());
				usuario.setDsSexo(rs.getString("sexo"));
				usuario.setDsEmail(rs.getString("ds_email"));
				usuario.setDsProfissao(rs.getString("ds_profissao"));
				usuario.setVlSalario(rs.getDouble("vl_salario"));
				usuario.setSenha(rs.getString("senha"));

				
				int idUser = rs.getInt("cd_usuario");
				
				BancoDAO dao = new BancoDAO(Conexao.abrirConexao());
				Banco banco =	dao.BuscarCdBanco(idUser);
				usuario.setCdUsuario(banco);
				list.add(usuario);
				
			}
			
			ps.close();
			conexao.close();	
		
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
}
