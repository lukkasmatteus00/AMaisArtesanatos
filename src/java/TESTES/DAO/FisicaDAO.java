package TESTES.DAO;

import ConexaoDB.Conexao;
import JavaBeans.Fisica;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class FisicaDAO {
  public static List<Fisica> relatorio() {
    List<Fisica> Fisica_list =
            new ArrayList<Fisica>();
    try {
        Connection conexao = Conexao.criaConexao();
        Statement stm = conexao.createStatement();
        ResultSet rs = stm.executeQuery(
            "SELECT * FROM Fisica");

        Fisica_list = new ArrayList<Fisica>();

        while (rs.next()) {
            Fisica fisica = new Fisica();
            fisica.setCpf(rs.getString("cpf"));
            fisica.setNomeCompleto(rs.getString("nomeCompleto"));
            fisica.setDataNascimento(rs.getDate("dataNascimento"));
            fisica.setSexo(rs.getString("sexo"));
            fisica.setEmail(rs.getString("email"));
            fisica.setEndereco(EnderecoDAO.consultarId(rs.getInt("idEndereco")));
            fisica.setTelefone(TelefoneDAO.consultarId(rs.getInt("idTelefone")));
            Fisica_list.add(fisica);
        }
    } catch (SQLException e) {
        System.out.println("Erro de SQL " + e.getMessage());
    }
    return Fisica_list;
}
    
public static int inserir(Fisica fisica) {
    int ret = 0;
    try {
            Connection conexao = Conexao.criaConexao();
            PreparedStatement pstm = conexao.prepareStatement(
                    "INSERT INTO Fisica "
                    + "(cpf, nomeCompleto, dataNascimento, sexo, email, Endereco_idEndereco, Telefone_idTelefone) VALUES "
                    + "(?, ?, ?, ?, ?, ?, ?)");
            pstm.setString(1, fisica.getCpf());
            pstm.setString(2, fisica.getNomeCompleto());
            pstm.setDate(3, (Date) fisica.getDataNascimento());
            pstm.setString(4, fisica.getSexo());
            pstm.setString(5, fisica.getEmail());
            pstm.setInt(6, fisica.getEndereco().getIdEndereco());
            pstm.setInt(7, fisica.getTelefone().getIdTelefone());
            ret = pstm.executeUpdate();
         } catch (SQLException e){ 
        System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }

public static int exclui(String cpf) {
    int ret = 0;
    try {
        Connection cn = Conexao.criaConexao();
        PreparedStatement pstm = cn.prepareStatement(
                "DELETE FROM Fisica WHERE cpf = ?");
        pstm.setString(1, cpf);
        ret = pstm.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Erro de SQL: " + e.getMessage());
    }
    return ret;
}

public static Fisica consultarCPF(String cpf) {
        Fisica Cliente = new Fisica();
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT * FROM Fisica WHERE "
                    + "cpf = ?");
            pstm.setString(1, cpf);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                Cliente = new Fisica();
            Cliente.setCpf(rs.getString("cpf"));
            Cliente.setNomeCompleto(rs.getString("nomeCompleto"));
            Cliente.setDataNascimento(rs.getDate("dataNascimento"));
            Cliente.setSexo(rs.getString("sexo"));
            Cliente.setEmail(rs.getString("email"));
            Cliente.setEndereco(EnderecoDAO.consultarId(rs.getInt("Endereco_idEndereco")));
            Cliente.setTelefone(TelefoneDAO.consultarId(rs.getInt("Telefone_idTelefone")));
            
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Cliente;
    }

public static Fisica consultarNome(String nomeCompleto) {
        Fisica Cliente = new Fisica();
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT * FROM Fisica WHERE "
                    + "nomeCompleto LIKE = ?%");
            pstm.setString(1, nomeCompleto);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                Cliente = new Fisica();
            Cliente.setCpf(rs.getString("cpf"));
            Cliente.setNomeCompleto(rs.getString("nomeCompleto"));
            Cliente.setDataNascimento(rs.getDate("dataNascimento"));
            Cliente.setSexo(rs.getString("sexo"));
            Cliente.setEmail(rs.getString("email"));
            Cliente.setEndereco(EnderecoDAO.consultarId(rs.getInt("Endereco_idEndereco")));
            Cliente.setTelefone(TelefoneDAO.consultarId(rs.getInt("Telefone_idTelefone")));
            
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Cliente;
    }

public static int alterar(Fisica fisica ) {
       int ret = 0;
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "UPDATE Fisica SET nomeCompleto = ? , dataNascimento = ?,"
                            + " sexo = ? , email = ?  WHERE cpf = ?");
            pstm.setString(1, fisica.getNomeCompleto());
            pstm.setDate(2, (Date) fisica.getDataNascimento());
            pstm.setString(3, fisica.getSexo());
            pstm.setString(4, fisica.getEmail());
            
            pstm.setString(5, fisica.getCpf());
            ret = pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }

}
