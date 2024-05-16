package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fiap.Endereco;

public class EnderecoDAO {
    private Connection conexao;

    public EnderecoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void gravar(Endereco endereco) {
        String sql = "INSERT INTO T_SIP_ENDERECO (cd_endereco, ds_logradouro, cep, nm_rua, nm_bairro, nm_cidade, nm_estado, nr_imovel, cd_usuario)"
                   + " VALUES (SQ_T_ENDERECO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, endereco.getTipoEndereco());
            ps.setString(2, endereco.getNrCep());
            ps.setString(3, endereco.getNmRua());
            ps.setString(4, endereco.getNmBairro());
            ps.setString(5, endereco.getNmCidade());
            ps.setString(6, endereco.getNmEstado());
            ps.setInt(7, endereco.getNrImovel());
            ps.setInt(8, endereco.getCdUsuario());

            ps.execute();
            System.out.println("Endereço registrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao gravar o endereço: " + e.getMessage());
        }
    }

    public void excluir(int cdEndereco) {
        String sql = "DELETE FROM T_SIP_ENDERECO WHERE cd_endereco = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, cdEndereco);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Endereço excluído com sucesso!");
            } else {
                System.out.println("Nenhum endereço excluído.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluir endereço: " + e.getMessage());
        }
    }

    public void atualizar(Endereco endereco) {
        String sql = "UPDATE T_SIP_ENDERECO SET "
                   + "ds_logradouro = ?, "
                   + "cep = ?, "
                   + "nm_rua = ?, "
                   + "nm_bairro = ?, "
                   + "nm_cidade = ?, "
                   + "nm_estado = ?, "
                   + "nr_imovel = ?, "
                   + "cd_usuario = ? "
                   + "WHERE cd_endereco = ? AND cd_usuario = ?"; // Adiciona verificação para cd_usuario

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, endereco.getTipoEndereco());
            ps.setString(2, endereco.getNrCep());
            ps.setString(3, endereco.getNmRua());
            ps.setString(4, endereco.getNmBairro());
            ps.setString(5, endereco.getNmCidade());
            ps.setString(6, endereco.getNmEstado());
            ps.setInt(7, endereco.getNrImovel());
            ps.setInt(8, endereco.getCdUsuario());
            ps.setInt(9, endereco.getCdEndereco());
            ps.setInt(10, endereco.getCdUsuario()); // Garante que a atualização só ocorre se o cd_usuario corresponder

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Endereço atualizado com sucesso!");
            } else {
                System.out.println("Nenhuma alteração realizada. Verifique o ID do endereço e o usuário.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar endereço: " + e.getMessage());
        }
    }


    public List<Endereco> getAll() {
        String sql = "SELECT * FROM T_SIP_ENDERECO ORDER BY cd_endereco";
        List<Endereco> listaEnderecos = new ArrayList<Endereco>();

        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setCdEndereco(rs.getInt("cd_endereco"));
                endereco.setTipoEndereco(rs.getString("ds_logradouro"));
                endereco.setNrCep(rs.getString("cep"));
                endereco.setNmRua(rs.getString("nm_rua"));
                endereco.setNmBairro(rs.getString("nm_bairro"));
                endereco.setNmCidade(rs.getString("nm_cidade"));
                endereco.setNmEstado(rs.getString("nm_estado"));
                endereco.setNrImovel(rs.getInt("nr_imovel"));
                endereco.setCdUsuario(rs.getInt("cd_usuario"));

                listaEnderecos.add(endereco);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar endereços: " + e.getMessage());
        }

        return listaEnderecos;
    }
   }
