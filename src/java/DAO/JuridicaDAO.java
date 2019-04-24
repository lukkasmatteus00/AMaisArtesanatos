package DAO;

import ConexaoDB.Conexao;
import JavaBeans.Juridica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JuridicaDAO {
    public static int inserir(Juridica juri) {
        int ret = 0;
        try {
            Connection conexao = Conexao.criaConexao();
            PreparedStatement pstm = conexao.prepareStatement(
                    "INSERT INTO Juridica "
                    + "( email, razaoSocial, cnpj"
                    + ", logradouro, cep, complemento, "
                    + "bairro, cidade, estado, numero, telefoneCel,"
                    + "telefoneFixo) VALUES "
                    + "(' "  + juri.getEmail()
                            + "' , '" + juri.getRazaoSocial()
                            + "' , '" + juri.getCnpj() 
                            + "' , '" + juri.getLogradouro()
                            + "' , '" + juri.getCep() 
                            + "' , '" + juri.getComplemento()
                            + "' , '" + juri.getBairro()
                            + "' , '" + juri.getCidade()
                            + "' , '" + juri.getEstado()
                            + "' , '" + juri.getNumero() 
                            + "' , '" + juri.getTelefoneCel()
                            + "' , '" + juri.getTelefoneFixo()
                    + "') ");

            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }

    public static int alterar(Juridica jur) {
        int ret = 0;
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "UPDATE Juridica SET  `razaoSocial` = '"+jur.getRazaoSocial()+"', "
                            + " `email` = '"+jur.getEmail()+"', "
                            + " `telefoneCel` = '"+jur.getTelefoneCel()+"', "
                            + " `telefoneFixo` = '"+jur.getTelefoneFixo()+"', "
                            + " `logradouro` = '"+jur.getLogradouro()+"', "
                            + " `numero` = '"+jur.getNumero()+"', "
                            + " `complemento` = '"+jur.getComplemento()+"', "
                            + " `cidade` = '"+jur.getCidade()+"', "
                            + " `cep` = '"+jur.getCep()+"', "
                            + " `bairro` = '"+jur.getBairro()+"', "
                            + " `estado` = '"+ jur.getEstado()+"' "
                            + " WHERE cnpj = '"+jur.getCnpj()+"' ");

            ret = pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }  
    
    public List<Juridica> listar() {
        List<Juridica> lista = new ArrayList<>();
        try {
            Connection cn = Conexao.criaConexao();
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Juridica");
            while (rs.next()) {
                Juridica jur = new Juridica();
                
                jur.setCnpj(rs.getString("cnpj"));
                jur.setRazaoSocial(rs.getString("razãoSocial"));
                
                jur.setEmail(rs.getString("email"));
                jur.setTelefoneCel(rs.getString("telefoneCel"));
                jur.setTelefoneFixo(rs.getString("telefoneFixo"));
                
                jur.setLogradouro(rs.getString("logradouro"));
                jur.setNumero(rs.getString("numero"));
                jur.setCep(rs.getString("cep"));
                jur.setComplemento(rs.getString("complemento"));
                jur.setCidade(rs.getString("cidade"));
                jur.setBairro(rs.getString("bairro"));
                jur.setEstado(rs.getString("estado"));
                
                lista.add(jur);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public ArrayList consultar(Juridica jur ) {
        ArrayList<Juridica>jurionario = new ArrayList<Juridica>();
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT * FROM Juridica WHERE  `razaoSocial` LIKE '%" + jur.getRazaoSocial()
                    + "%' or `cnpj`  LIKE '%"+jur.getCnpj()+"%'");

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Juridica juri = new Juridica();
                juri.setCnpj(rs.getString("cnpj"));
                juri.setRazaoSocial(rs.getString("razaoSocial"));
                
                juri.setEmail(rs.getString("email"));
                juri.setTelefoneCel(rs.getString("telefoneCel"));
                juri.setTelefoneFixo(rs.getString("telefoneFixo"));
                
                juri.setLogradouro(rs.getString("logradouro"));
                juri.setNumero(rs.getString("numero"));
                juri.setCep(rs.getString("cep"));
                juri.setComplemento(rs.getString("complemento"));
                juri.setCidade(rs.getString("cidade"));
                juri.setBairro(rs.getString("bairro"));
                juri.setEstado(rs.getString("estado"));
                
                jurionario.add(juri);
                
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return jurionario;
    }
    
    public static int exclui(String cnpj) {
        int ret = 0;
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "DELETE FROM Juridica WHERE cnpj = ?");
            pstm.setString(1, cnpj);
            ret = pstm.executeUpdate();
            JuridicaDAO.exclui(cnpj);
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }
}
