package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fiap.ContaInvestimento;

public class ContaInvestimentoDAO {

    private Connection conexao;

    public ContaInvestimentoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void gravar(ContaInvestimento contaInvestimento) {
        String sql = "INSERT INTO T_CONTA_INVESTIMENTOS (id_investimento, id_banco, vl_investido, rendimento_esperado, tipo_investimento)"
                   + " VALUES (SQ_T_INVESTIMENTOS.NEXTVAL, ?, ?, ?, ?)";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, contaInvestimento.getIdBanco());
            ps.setDouble(2, contaInvestimento.getSaldoInvestido());
            ps.setDouble(3, contaInvestimento.getTaxaRendimento());
            ps.setString(4, contaInvestimento.getTipoInvestimento());

            ps.execute();
            System.out.println("Conta de investimento registrada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao gravar conta de investimento: " + e.getMessage());
        }
    }

    public void excluir(int idInvestimento) {
        String sql = "DELETE FROM T_CONTA_INVESTIMENTOS WHERE id_investimento = ?";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, idInvestimento);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Conta de investimento excluída com sucesso!");
            } else {
                System.out.println("Nenhuma conta de investimento excluída.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluir conta de investimento: " + e.getMessage());
        }
    }

    public void atualizar(ContaInvestimento contaInvestimento) {
        String sql = "UPDATE T_CONTA_INVESTIMENTOS SET vl_investido = ?, rendimento_esperado = ?, tipo_investimento = ? WHERE id_investimento = ?";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setDouble(1, contaInvestimento.getSaldoInvestido());
            ps.setDouble(2, contaInvestimento.getTaxaRendimento());
            ps.setString(3, contaInvestimento.getTipoInvestimento());
            ps.setString(4, contaInvestimento.getIdInvestimento());


            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Conta de investimento atualizada com sucesso!");
            } else {
                System.out.println("Nenhuma alteração realizada na conta de investimento.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar conta de investimento: " + e.getMessage());
        }
    }

    public List<ContaInvestimento> getAll() {
        List<ContaInvestimento> list = new ArrayList<>();
        String sql = "SELECT * FROM T_CONTA_INVESTIMENTOS ORDER BY id_investimento";

        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ContaInvestimento contaInvestimento = new ContaInvestimento();
                contaInvestimento.setIdInvestimento(rs.getString("id_investimento"));
                contaInvestimento.setIdBanco(rs.getInt("id_banco"));
                contaInvestimento.setSaldoInvestido(rs.getDouble("vl_investido"));
                contaInvestimento.setTaxaRendimento(rs.getDouble("rendimento_esperado"));
                contaInvestimento.setTipoInvestimento(rs.getString("tipo_investimento"));
                list.add(contaInvestimento);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar contas de investimento: " + e.getMessage());
        }
        return list;
    }
}
