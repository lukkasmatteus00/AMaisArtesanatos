package TESTES.DAO;

import ConexaoDB.Conexao;
import JavaBeans.Telefone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TelefoneDAO {
   public static List<Telefone> relatorio() {
    List<Telefone> Telefone_list =
            new ArrayList<Telefone>();
    try {
        Connection conexao = Conexao.criaConexao();
        Statement stm = conexao.createStatement();
        ResultSet rs = stm.executeQuery(
            "SELECT * FROM Telefone");

        Telefone_list = new ArrayList<Telefone>();

        while (rs.next()) {
            Telefone telefone = new Telefone();
            telefone.setIdTelefone(rs.getInt("idTelefone"));
            telefone.setNumero(rs.getString("numero"));
            Telefone_list.add(telefone);
        }
    } catch (SQLException e) {
        System.out.println("Erro de SQL " + e.getMessage());
    }
    return Telefone_list;
}
 
public static int inserir(Telefone telefone) {
    int ret = 0;
    try {
            Connection conexao = Conexao.criaConexao();
            PreparedStatement pstm = conexao.prepareStatement(
                    "INSERT INTO Telefone (numero) VALUES (?)");
            pstm.setString(1, telefone.getNumero());
            ret = pstm.executeUpdate();
         } catch (SQLException e) {
        System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }

public static int exclui(int idTelefone) {
    int ret = 0;
    try {
        Connection cn = Conexao.criaConexao();
        PreparedStatement pstm = cn.prepareStatement(
                "DELETE FROM Telefone WHERE idTelefone = ?");
        pstm.setInt(1, idTelefone);
        ret = pstm.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Erro de SQL: " + e.getMessage());
    }
    return ret;
}

public static Telefone consultarId (int idTelefone) {
        Telefone Fone = new Telefone();
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT * FROM Telefone WHERE idTelefone = ?");
            pstm.setInt(1, idTelefone);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                Fone = new Telefone();
            Fone.setIdTelefone(rs.getInt("IdTelefone"));
            Fone.setNumero(rs.getString("numero"));
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Fone;
    }


 public static int alterar(Telefone telefone) {
        int ret = 0;
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "UPDATE Telefone SET numero = ?  WHERE idTelefone = ?");
            pstm.setString(1, telefone.getNumero());
            
            pstm.setInt(2, telefone.getIdTelefone());
            ret = pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    } 
}
