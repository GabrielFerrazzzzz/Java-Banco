package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fiap.CartaoDeCredito;

public class CartaoCCDAO {

    private Connection conexao;

    public CartaoCCDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void gravar(CartaoDeCredito cartao) {
        String sql = "INSERT INTO T_CARTAO_CC (nr_cartao, nm_cartao, dt_exp, nr_seguranca, ds_apelido, cd_usuario) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, cartao.getNrCartao());
            ps.setString(2, cartao.getNmCartao());
            ps.setDate(3, java.sql.Date.valueOf(cartao.getDtExpiracao()));
            ps.setInt(4, cartao.getNrSeguranca());
            ps.setString(5, cartao.getApelido());
            ps.setInt(6, cartao.getCdUsuario());
            ps.executeUpdate();
            System.out.println("Cartão de Crédito inserido com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir cartão de crédito: " + e.getMessage());
        }
    }

    public void excluir(String nrCartao) {
        String sql = "DELETE FROM T_CARTAO_CC WHERE nr_cartao = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, nrCartao);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Cartão de crédito excluído com sucesso!");
            } else {
                System.out.println("Nenhum cartão de crédito excluído.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluir cartão de crédito: " + e.getMessage());
        }
    }

    public void atualizar(CartaoDeCredito cartao) {
        String sql = "UPDATE T_CARTAO_CC SET ds_apelido = ? WHERE nr_cartao = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, cartao.getApelido());
            ps.setString(2, cartao.getNrCartao());
            ps.executeUpdate();
            System.out.println("Apelido do Cartão de crédito atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o apelido do cartão de crédito: " + e.getMessage());
        }
    }

    public List<CartaoDeCredito> getAll() {
        List<CartaoDeCredito> cartoes = new ArrayList<>();
        String sql = "SELECT * FROM T_CARTAO_CC ORDER BY nr_cartao";
        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
            	CartaoDeCredito cartao = new CartaoDeCredito();
                cartao.setNrCartao(rs.getString("nr_cartao"));
                cartao.setNmCartao(rs.getString("nm_cartao"));
				Date data = rs.getDate("dt_exp");
				cartao.setDtExpiracao(data.toLocalDate());
                cartao.setNrSeguranca(rs.getInt("nr_seguranca"));
                cartao.setApelido(rs.getString("ds_apelido"));
                cartao.setCdUsuario(rs.getInt("cd_usuario"));
                cartoes.add(cartao);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar cartões de crédito: " + e.getMessage());
        }
        return cartoes;
    }
}
