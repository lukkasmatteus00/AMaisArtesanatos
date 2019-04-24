package DAO;

import ConexaoDB.Conexao;
import JavaBeans.FaleConosco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FaleConoscoDAO {
  
     /*public static int inserir(FaleConosco fala) {
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
            String sql_func = "INSERT INTO faleConosco "
                    + "(matricula, senha, cargo, nomeCompleto, cpf, dataAdmissao, Endereco_idEndereco) VALUES "
                    + "('" + fala.getMatricula() + "', '"
                    + fala.getSenha() + "', '" + fala.getCargo() + "', '"
                    + fala.getNomeCompleto() + "', '" + fala.getCpf() + "', '"
                    + fala.getDataAdmissao() + "', " + idEndereco + " )";

            PreparedStatement pstm3 = conexao.prepareStatement(sql_func);
            System.out.println("Func: "+sql_func);
            pstm3.executeUpdate();
            
            
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }*/
    
    public static int inserir(FaleConosco fale) {
        int ret = 0;
        try {
            Connection conexao = Conexao.criaConexao();
            PreparedStatement pstm = conexao.prepareStatement(
                    "INSERT INTO FaleConosco "
                    + "(titulo, mensagem, Funcionario_matricula) VALUES "
                    + "(' " + fale.getTituto()
                            + "' , '" + fale.getMensagem()
                            + "' , '" + fale.getFuncionario()
                    + "') ");

            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }

}
