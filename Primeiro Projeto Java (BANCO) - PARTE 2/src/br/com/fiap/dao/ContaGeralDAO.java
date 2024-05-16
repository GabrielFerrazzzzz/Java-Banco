package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fiap.ContaGeral;

public class ContaGeralDAO {

    private Connection conexao;

    public ContaGeralDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void gravar(ContaGeral contaGeral) {
        String sql = "INSERT INTO T_CONTA (id_conta, id_banco, tx_mensalidade, tipo_conta)"
                   + " VALUES (SQ_T_CONTA.NEXTVAL, ?, ?, ?)";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, contaGeral.getIdBanco());
            ps.setDouble(2, contaGeral.getTxMensalidade());
            ps.setString(3, contaGeral.getTipoConta());

            ps.execute();
            System.out.println("Conta geral registrada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao gravar conta geral: " + e.getMessage());
        }
    }

    public void excluir(int idConta) {
        String sql = "DELETE FROM T_CONTA WHERE id_conta = ?";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, idConta);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Conta geral excluída com sucesso!");
            } else {
                System.out.println("Nenhuma conta geral excluída.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluir conta geral: " + e.getMessage());
        }
    }

    public void atualizar(ContaGeral contaGeral) {
        String sql = "UPDATE T_CONTA SET id_banco = ?, tx_mensalidade = ?, tipo_conta = ? WHERE id_conta = ? AND id_banco = ?";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, contaGeral.getIdBanco());
            ps.setDouble(2, contaGeral.getTxMensalidade());
            ps.setString(3, contaGeral.getTipoConta());
            ps.setInt(4, contaGeral.getIdConta());
            ps.setInt(5, contaGeral.getIdBanco());

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Conta geral atualizada com sucesso!");
            } else {
                System.out.println("Nenhuma alteração realizada na conta geral.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar conta geral: " + e.getMessage());
        }
    }

    public List<ContaGeral> getAll() {
        List<ContaGeral> list = new ArrayList<>();
        String sql = "SELECT * FROM T_CONTA ORDER BY id_conta";

        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ContaGeral contaGeral = new ContaGeral();
                contaGeral.setIdConta(rs.getInt("id_conta"));
                contaGeral.setIdBanco(rs.getInt("id_banco"));
                contaGeral.setTxMensalidade(rs.getDouble("tx_mensalidade"));
                contaGeral.setTipoConta(rs.getString("tipo_conta"));
                list.add(contaGeral);
            }
        } catch (SQLException e) {

        System.err.println("Erro ao listar contas gerais: " + e.getMessage());
}
        return list;
}
}

