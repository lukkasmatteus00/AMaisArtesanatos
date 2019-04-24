package TESTES.DAO;

import ConexaoDB.Conexao;
import JavaBeans.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EnderecoDAO {
    public static List<Endereco> relatorio() {
    List<Endereco> Endereco_list =
            new ArrayList<Endereco>();
    try {
        Connection conexao = Conexao.criaConexao();
        Statement stm = conexao.createStatement();
        ResultSet rs = stm.executeQuery(
            "SELECT * FROM Endereco");

        Endereco_list = new ArrayList<Endereco>();

        while (rs.next()) {
            Endereco endereco = new Endereco();
            endereco.setIdEndereco(rs.getInt("IdEndereco"));
            endereco.setTipoEndereco(rs.getString("tipoEndereco"));
            endereco.setCep(rs.getString("cep"));
            endereco.setEndereco(rs.getString("Endereco"));
            endereco.setNumero(rs.getString("numero"));
            endereco.setReferencia(rs.getString("referencia"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setCidade(rs.getString("cidade"));
            endereco.setEstado(rs.getString("estado"));
            Endereco_list.add(endereco);
        }
    } catch (SQLException e) {
        System.out.println("Erro de SQL " + e.getMessage());
    }
    return Endereco_list;
}
 
public static int inserir(Endereco endereco) {
    int ret = 0;
    try {
            Connection conexao = Conexao.criaConexao();
            PreparedStatement pstm = conexao.prepareStatement(
                    "INSERT INTO Endereco "
                    + "(tipoEndereco, cep, endereco, numero, "
                            + "referencia, bairro, cidade, estado) VALUES "
                    + "(?,?,?,?,?,?,?,?)");
            pstm.setString(1, endereco.getTipoEndereco());
            pstm.setString(2, endereco.getCep());
            pstm.setString(3, endereco.getEndereco());
            pstm.setString(4, endereco.getNumero());
            pstm.setString(5, endereco.getReferencia());
            pstm.setString(6, endereco.getBairro());
            pstm.setString(7, endereco.getCidade());
            pstm.setString(8, endereco.getEstado());
            ret = pstm.executeUpdate();
         } catch (SQLException e) {
        System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }

public static int exclui(int idEndereco) {
    int ret = 0;
    try {
        Connection cn = Conexao.criaConexao();
        PreparedStatement pstm = cn.prepareStatement(
                "DELETE FROM Endereco WHERE idEndereco = ?");
        pstm.setInt(1, idEndereco);
        ret = pstm.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Erro de SQL: " + e.getMessage());
    }
    return ret;
}

public static Endereco consultarId (int idEndereco) {
        Endereco Address = new Endereco();
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT * FROM Endereco WHERE idEndereco = ?");
            pstm.setInt(1, idEndereco);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                Address = new Endereco();
            Address.setIdEndereco(rs.getInt("IdEndereco"));
            Address.setTipoEndereco(rs.getString("tipoEndereco"));
            Address.setCep(rs.getString("cep"));
            Address.setEndereco(rs.getString("Endereco"));
            Address.setNumero(rs.getString("numero"));
            Address.setReferencia(rs.getString("referencia"));
            Address.setBairro(rs.getString("bairro"));
            Address.setCidade(rs.getString("cidade"));
            Address.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Address;
    }

public static Endereco consultarCidade_Bairro (String cidade , String bairro) {
        Endereco Address = new Endereco();
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT * FROM Endereco WHERE cidade = ? OR bairro = ?");
            pstm.setString(1, cidade);
            pstm.setString(2, bairro);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                Address = new Endereco();
            Address.setIdEndereco(rs.getInt("IdEndereco"));
            Address.setTipoEndereco(rs.getString("tipoEndereco"));
            Address.setCep(rs.getString("cep"));
            Address.setEndereco(rs.getString("Endereco"));
            Address.setNumero(rs.getString("numero"));
            Address.setReferencia(rs.getString("referencia"));
            Address.setBairro(rs.getString("bairro"));
            Address.setCidade(rs.getString("cidade"));
            Address.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Address;
    }


 public static int alterar(Endereco endereco) {
        int ret = 0;
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "UPDATE Endereco SET tipoEndereco = ?,"
                            + " cep = ? , endereco = ?,"
                            + " numero = ?, referencia = ?, bairro = ?, cidade = ?, estado = ?  WHERE idEndereco = ?");
            pstm.setString(1, endereco.getTipoEndereco());
            pstm.setString(2, endereco.getCep());
            pstm.setString(3, endereco.getEndereco());
            pstm.setString(4, endereco.getNumero());
            pstm.setString(5, endereco.getReferencia());
            pstm.setString(6, endereco.getBairro());
            pstm.setString(7, endereco.getCidade());
            pstm.setString(8, endereco.getEstado());
            
            pstm.setInt(9, endereco.getIdEndereco()); 
            ret = pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }
}
