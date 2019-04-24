package TESTES.DAO;

import ConexaoDB.Conexao;
import JavaBeans.Endereco;
import JavaBeans.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    /*public static List<Funcionario> relatorio() {
        List<Funcionario> Funcionario_list
                = new ArrayList<Funcionario>();
        try {
            Connection conexao = Conexao.criaConexao();
            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery(
                    "SELECT * FROM Funcionario");

            Funcionario_list = new ArrayList<Funcionario>();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setMatricula(rs.getString("matricula"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setNomeCompleto(rs.getString("nomeCompleto"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setDataAdmissao(rs.getString("dataAdmissao"));
                funcionario.setEndereco(rs.getInt("idEndereco"));
                Funcionario_list.add(funcionario);
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL " + e.getMessage());
        }
        return Funcionario_list;
    }*/

    public static int inserir(Funcionario funcionario, Endereco enderec) {
        int ret = 0;
        int idEndereco;
        try {
            Connection conexao = Conexao.criaConexao();
            PreparedStatement pstm = conexao.prepareStatement(
                    "SELECT idEndereco FROM endereco WHERE tipoEndereco LIKE '" + enderec.getTipoEndereco()
                    + "' AND cep LIKE '" + enderec.getCep()
                    + "' AND endereco LIKE '" + enderec.getEndereco()
                    + "' AND numero LIKE '" + enderec.getNumero()
                    + "' AND complemento LIKE '" + enderec.getComplemento()
                    + "' AND bairro LIKE '" + enderec.getBairro()
                    + "' AND cidade LIKE '" + enderec.getCidade()
                    + "' AND estado LIKE '" + enderec.getEstado() + "' ");

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                idEndereco = rs.getInt("idEndereco");

            } else {
                PreparedStatement pstm2 = conexao.prepareStatement(
                        "INSERT INTO endereco "
                        + "(tipoEndereco, cep, endereco, numero, complemento, bairro, cidade, estado) VALUES "
                        + "('" + enderec.getTipoEndereco() + "', '" + enderec.getCep() + "', '"
                        + enderec.getEndereco() + "', '" + enderec.getNumero() + "', '"
                        + enderec.getComplemento() + "', '" + enderec.getBairro() + "', '"
                        + enderec.getCidade() + "', '" + enderec.getEstado() + "' )");
                pstm2.executeUpdate();
                ResultSet id = pstm2.getGeneratedKeys();
                idEndereco = id.getInt("idEndereco");

            }
            String sql_func = "INSERT INTO funcionario "
                    + "(matricula, senha, cargo, nomeCompleto, cpf, dataAdmissao, Endereco_idEndereco) VALUES "
                    + "('" + funcionario.getMatricula() + "', '"
                    + funcionario.getSenha() + "', '" + funcionario.getCargo() + "', '"
                    + funcionario.getNomeCompleto() + "', '" + funcionario.getCpf() + "', '"
                    + funcionario.getDataAdmissao() + "', " + idEndereco + " )";

            PreparedStatement pstm3 = conexao.prepareStatement(sql_func);
            System.out.println("Func: "+sql_func);
            pstm3.executeUpdate();
            
            
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }

   /* public static int exclui(String matricula) {
        int ret = 0;
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "DELETE FROM Funcionario WHERE matricula = ?");
            pstm.setString(1, matricula);
            ret = pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }

    public static int alterar(Funcionario funcionario) {
        int ret = 0;
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "UPDATE Funcionario SET matricula = ?, senha= ?, cargo= ?, nomeCompleto= ?, dataAdmissao = ?  WHERE cpf = ?");

            pstm.setString(1, funcionario.getMatricula());
            pstm.setString(3, funcionario.getSenha());
            pstm.setString(4, funcionario.getCargo());
            pstm.setString(5, funcionario.getNomeCompleto());
            pstm.setString(6, funcionario.getDataAdmissao());

            pstm.setString(7, funcionario.getCpf());
            ret = pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }*/
}
