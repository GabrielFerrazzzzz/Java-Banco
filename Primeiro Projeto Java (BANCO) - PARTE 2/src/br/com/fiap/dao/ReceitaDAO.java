package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.fiap.Receita;

public class ReceitaDAO {
    private Connection conexao;

    public ReceitaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void gravar(Receita receita) {
        String sql = "INSERT INTO T_SIP_RECEITA (id_receita, vl_recebido, id_transacao) VALUES (SQ_T_RECEITA, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setDouble(1, receita.getVlRecebido());
            ps.setInt(2, receita.getIdTransacao());
            ps.executeUpdate();
            System.out.println("Receita inserida com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir receita: " + e.getMessage());
        }
    }

    public void atualizar(Receita receita) {
        String sql = "UPDATE T_SIP_RECEITA SET vl_recebido = ? WHERE id_receita = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setDouble(1, receita.getVlRecebido());
            ps.setInt(2, receita.getIdReceita());
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Receita atualizada com sucesso!");
            } else {
                System.out.println("Nenhuma receita foi atualizada.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar receita: " + e.getMessage());
        }
    }

    public void excluir(int idReceita) {
        String sql = "DELETE FROM T_SIP_RECEITA WHERE id_receita = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, idReceita);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Receita excluída com sucesso!");
            } else {
                System.out.println("Nenhuma receita foi excluída.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluir receita: " + e.getMessage());
        }
    }
    public List<Receita> getAll() {
        List<Receita> receitas = new ArrayList<>();
        String sql = "SELECT * FROM T_SIP_RECEITA";
        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Receita receita = new Receita();
                receita.setIdReceita(rs.getInt("id_receita"));
                receita.setVlRecebido(rs.getDouble("vl_recebido"));
                receita.setIdTransacao(rs.getInt("id_transacao"));
                receitas.add(receita);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar receitas: " + e.getMessage());
        }
        return receitas;
    }
}
