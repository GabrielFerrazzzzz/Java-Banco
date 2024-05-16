package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fiap.Carteira;

public class CarteiraDAO {

    private Connection conexao;

    public CarteiraDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void gravar(Carteira carteira) {
        String sql = "INSERT INTO T_SIP_CARTEIRA (cd_carteira, cd_usuario, vl_saldo) VALUES (SQ_T_CARTEIRA, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, carteira.getCdUsuario());
            ps.setDouble(2, carteira.getSaldo());
            ps.executeUpdate();
            System.out.println("Carteira inserida com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir carteira: " + e.getMessage());
        }
    }

    public void excluir(int cdCarteira) {
        String sql = "DELETE FROM T_SIP_CARTEIRA WHERE cd_carteira = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, cdCarteira);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Carteira excluída com sucesso!");
            } else {
                System.out.println("Nenhuma carteira excluída.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluir carteira: " + e.getMessage());
        }
    }

    public void atualizar(Carteira carteira) {
        String sql = "UPDATE T_SIP_CARTEIRA SET vl_saldo = ? WHERE cd_carteira = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setDouble(1, carteira.getSaldo());
            ps.setInt(2, carteira.getCdCarteira());
            ps.executeUpdate();
            System.out.println("Carteira atualizada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar carteira: " + e.getMessage());
        }
    }

    public List<Carteira> getAll() {
        List<Carteira> carteiras = new ArrayList<>();
        String sql = "SELECT * FROM T_SIP_CARTEIRA ORDER BY cd_carteira";
        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Carteira carteira = new Carteira();
                carteira.setCdCarteira(0);
                carteira.setCdUsuario(rs.getInt("cd_usuario"));
                carteira.setSaldo(rs.getDouble("vl_saldo"));
                carteiras.add(carteira);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar carteiras: " + e.getMessage());
        }
        return carteiras;
    }
}
