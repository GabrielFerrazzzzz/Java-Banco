package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fiap.Telefone;

public class TelefoneDAO {

    private Connection conexao;

    public TelefoneDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void gravar(Telefone telefone) {
        String sql = "INSERT INTO T_SIP_TELEFONE (cd_telefone, ddd, nr_telefone, cd_usuario) VALUES (SQ_T_TELEFONE, ?, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, telefone.getDDD());
            ps.setInt(2, telefone.getNrCompleto());
            ps.setInt(3, telefone.getCdUsuario());
            ps.executeUpdate();
            System.out.println("Telefone inserido com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir telefone: " + e.getMessage());
        }
    }

    public void excluir(int cdTelefone) {
        String sql = "DELETE FROM T_SIP_TELEFONE WHERE cd_telefone = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, cdTelefone);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Telefone excluído com sucesso!");
            } else {
                System.out.println("Nenhum telefone excluído.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluir telefone: " + e.getMessage());
        }
    }

    public void atualizar(Telefone telefone) {
        String sql = "UPDATE T_SIP_TELEFONE SET ddd = ?, nr_telefone = ?, cd_usuario = ? WHERE cd_telefone = ? AND cd_usuario = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, telefone.getDDD());
            ps.setInt(2, telefone.getNrCompleto());
            ps.setInt(3, telefone.getCdUsuario());
            ps.setInt(4, telefone.getCdTelefone());
            ps.setInt(5, telefone.getCdUsuario());
            ps.executeUpdate();
            System.out.println("Telefone atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar telefone: " + e.getMessage());
        }
    }

    public List<Telefone> getAll() {
        List<Telefone> telefones = new ArrayList<>();
        String sql = "SELECT * FROM T_SIP_TELEFONE";
        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Telefone telefone = new Telefone();
                telefone.setCdTelefone(rs.getInt("cd_telefone"));
                telefone.setDDD(rs.getInt("ddd"));
                telefone.setNrCompleto(0);
                telefone.setCdUsuario(rs.getInt("cd_usuario"));
                telefones.add(telefone);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar telefones: " + e.getMessage());
        }
        return telefones;
    }
}
