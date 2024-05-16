package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fiap.Transacao;

public class TransacaoDAO {

    private Connection conexao;

    public TransacaoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void gravar(Transacao transacao) {
        String sql = "INSERT INTO T_SIP_TRANSACOES (id_transacao, ds_transacao, cd_carteira) VALUES (SQ_T_TRANSACOES, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, transacao.getDsTransacao());
            ps.setInt(2, transacao.getCdCarteira());
            ps.executeUpdate();
            System.out.println("Transação inserida com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir transação: " + e.getMessage());
        }
    }

    public void excluir(int idTransacao) {
        String sql = "DELETE FROM T_SIP_TRANSACOES WHERE id_transacao = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, idTransacao);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Transação excluída com sucesso!");
            } else {
                System.out.println("Nenhuma transação excluída.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluir transação: " + e.getMessage());
        }
    }

    public void atualizar(Transacao transacao) {
        String sql = "UPDATE T_SIP_TRANSACOES SET ds_transacao = ? WHERE id_transacao = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, transacao.getDsTransacao());
            ps.setInt(2, transacao.getIdTransacao());
            ps.executeUpdate();
            System.out.println("Transação atualizada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar transação: " + e.getMessage());
        }
    }

    public List<Transacao> getAll() {
        List<Transacao> transacoes = new ArrayList<>();
        String sql = "SELECT * FROM T_SIP_TRANSACOES ORDER BY id_transacao";
        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Transacao transacao = new Transacao();
                transacao.setIdTransacao(rs.getInt("id_transacao"));
                transacao.setDsTransacao(rs.getString("ds_transacao"));
                transacao.setCdCarteira(rs.getInt("cd_carteira"));
                transacoes.add(transacao);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar transações: " + e.getMessage());
        }
        return transacoes;
    }
}
