package TESTES.DAO;

import ConexaoDB.Conexao;
import JavaBeans.Juridica;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JuridicaDAO {
     public static List<Juridica> relatorio() {
    List<Juridica> Juridica_list =
            new ArrayList<Juridica>();
    try {
        Connection conexao = Conexao.criaConexao();
        Statement stm = conexao.createStatement();
        ResultSet rs = stm.executeQuery(
            "SELECT * FROM Juridica");

        Juridica_list = new ArrayList<Juridica>();

        while (rs.next()) {
            Juridica juridica = new Juridica();
            juridica.setCnpj(rs.getString("cnpj"));
            juridica.setRazaoSocial(rs.getString("razaoSocial"));
            juridica.setEmail(rs.getString("email"));
            juridica.setEndereco(EnderecoDAO.consultarId(rs.getInt("idEndereco")));
            juridica.setTelefone(TelefoneDAO.consultarId(rs.getInt("idTelefone")));
            Juridica_list.add(juridica);
        }
    } catch (SQLException e) {
        System.out.println("Erro de SQL " + e.getMessage());
    }
    return Juridica_list;
}
    
public static int inserir(Juridica juridica) {
    int ret = 0;
    try {
            Connection conexao = Conexao.criaConexao();
            PreparedStatement pstm = conexao.prepareStatement(
                    "INSERT INTO Juridica "
                    + "(cnpj, razaoSocial, email, Endereco_idEndereco, Telefone_idTelefone) VALUES "
                    + "(?, ?, ?, ?, ?)");
            pstm.setString(1, juridica.getCnpj());
            pstm.setString(2, juridica.getRazaoSocial());
            pstm.setString(3, juridica.getEmail());
            pstm.setInt(4, juridica.getEndereco().getIdEndereco());
            pstm.setInt(5, juridica.getTelefone().getIdTelefone());
            ret = pstm.executeUpdate();
         } catch (SQLException e){ 
        System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }

public static int exclui(String cnpj) {
    int ret = 0;
    try {
        Connection cn = Conexao.criaConexao();
        PreparedStatement pstm = cn.prepareStatement(
                "DELETE FROM Juridica WHERE cnpj = ?");
        pstm.setString(1, cnpj);
        ret = pstm.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Erro de SQL: " + e.getMessage());
    }
    return ret;
}

public static Juridica consultarCNPJ(String cnpj) {
        Juridica Cliente = new Juridica();
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT * FROM Juridica WHERE "
                    + "cnpj = ?");
            pstm.setString(1, cnpj);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                Cliente = new Juridica();
            Cliente.setCnpj(rs.getString("cnpj"));
            Cliente.setRazaoSocial(rs.getString("RazaoSocial"));
            Cliente.setEmail(rs.getString("email"));
            Cliente.setEndereco(EnderecoDAO.consultarId(rs.getInt("Endereco_idEndereco")));
            Cliente.setTelefone(TelefoneDAO.consultarId(rs.getInt("Telefone_idTelefone")));
            
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Cliente;
    }

public static Juridica consultarNome(String razaoSocial) {
        Juridica Cliente = new Juridica();
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT * FROM Juridica WHERE "
                    + "razaoSocial LIKE = ?%");
            pstm.setString(1, razaoSocial);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                Cliente = new Juridica();
            Cliente.setCnpj(rs.getString("cnpj"));
            Cliente.setRazaoSocial(rs.getString("RazaoSocial"));
            Cliente.setEmail(rs.getString("email"));
            Cliente.setEndereco(EnderecoDAO.consultarId(rs.getInt("Endereco_idEndereco")));
            Cliente.setTelefone(TelefoneDAO.consultarId(rs.getInt("Telefone_idTelefone")));
            
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Cliente;
    }

public static int alterar(Juridica juridica ) {
       int ret = 0;
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "UPDATE Juridica SET razaoSocial = ? , email = ?  WHERE cnpj = ?");
            pstm.setString(1, juridica.getRazaoSocial());
            pstm.setString(2, juridica.getEmail());
            
            pstm.setString(3, juridica.getCnpj());
            ret = pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    } 
}
