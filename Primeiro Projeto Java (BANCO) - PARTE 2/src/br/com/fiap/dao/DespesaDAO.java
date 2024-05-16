package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.fiap.Despesa;

public class DespesaDAO {
    private Connection conexao;

    public DespesaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void gravar(Despesa despesa) {
        String sql = "INSERT INTO T_SIP_DESPESA (id_despesa, vl_retirado, id_transacao) VALUES (SQ_T_DESPESA, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setDouble(1, despesa.getVlRetirado());
            ps.setInt(2, despesa.getIdTransacao());
            ps.executeUpdate();
            System.out.println("Despesa inserida com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir despesa: " + e.getMessage());
        }
    }

    public void atualizar(Despesa despesa) {
        String sql = "UPDATE T_SIP_DESPESA SET vl_retirado = ? WHERE id_despesa = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setDouble(1, despesa.getVlRetirado());
            ps.setInt(2, despesa.getIdDespesa());
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Despesa atualizada com sucesso!");
            } else {
                System.out.println("Nenhuma despesa foi atualizada.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar despesa: " + e.getMessage());
        }
    }

    public void excluir(int idDespesa) {
        String sql = "DELETE FROM T_SIP_DESPESA WHERE id_despesa = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, idDespesa);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Despesa excluída com sucesso!");
            } else {
                System.out.println("Nenhuma despesa foi excluída.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluir despesa: " + e.getMessage());
        }
    }
    public List<Despesa> getAll() {
        List<Despesa> despesas = new ArrayList<>();
        String sql = "SELECT * FROM T_SIP_DESPESA";
        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Despesa despesa = new Despesa();
                despesa.setIdDespesa(rs.getInt("id_despesa"));
                despesa.setVlRetirado(rs.getDouble("vl_retirado"));
                despesa.setIdTransacao(rs.getInt("id_transacao"));
                despesas.add(despesa);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar despesas: " + e.getMessage());
        }
        return despesas;
    }
}
