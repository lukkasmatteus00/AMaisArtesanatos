package DAO;

import ConexaoDB.Conexao;
import JavaBeans.Fisica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FisicaDAO {
public static int inserir(Fisica fis) {
        int ret = 0;
        try {
            Connection conexao = Conexao.criaConexao();
            PreparedStatement pstm = conexao.prepareStatement(
                    "INSERT INTO Fisica "
                    + "(sexo, email, nomeCompleto, cpf"
                    + ", dataNascimento, logradouro, cep, complemento, "
                    + "bairro, cidade, estado, numero, telefoneCel,"
                    + "telefoneFixo) VALUES "
                    + "(' " + fis.getSexo()
                            + "' , '" + fis.getEmail()
                            + "' , '" + fis.getNomeCompleto()
                            + "' , '" + fis.getCpf() 
                            + "' , '" + fis.getDataNascimento()
                            + "' , '" + fis.getLogradouro()
                            + "' , '" + fis.getCep() 
                            + "' , '" + fis.getComplemento()
                            + "' , '" + fis.getBairro()
                            + "' , '" + fis.getCidade()
                            + "' , '" + fis.getEstado()
                            + "' , '" + fis.getNumero() 
                            + "' , '" + fis.getTelefoneCel()
                            + "' , '" + fis.getTelefoneFixo()
                    + "') ");

            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }

    public static int alterar(Fisica fis) {
        int ret = 0;
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "UPDATE Fisica SET  `nomeCompleto` = '"+fis.getNomeCompleto()+"', "
                            + " `dataNascimento` = '"+fis.getDataNascimento()+"', "
                            + " `email` = '"+fis.getEmail()+"', "
                            + " `sexo` = '"+fis.getSexo()+"', "
                            + " `telefoneCel` = '"+fis.getTelefoneCel()+"', "
                            + " `telefoneFixo` = '"+fis.getTelefoneFixo()+"', "
                            + " `logradouro` = '"+fis.getLogradouro()+"', "
                            + " `numero` = '"+fis.getNumero()+"', "
                            + " `complemento` = '"+fis.getComplemento()+"', "
                            + " `cidade` = '"+fis.getCidade()+"', "
                            + " `cep` = '"+fis.getCep()+"', "
                            + " `bairro` = '"+fis.getBairro()+"', "
                            + " `estado` = '"+ fis.getEstado()+"' "
                            + " WHERE cpf = '"+fis.getCpf()+"' ");

            ret = pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    } 
    
    public List<Fisica> listar() {
        List<Fisica> lista = new ArrayList<>();
        try {
            Connection cn = Conexao.criaConexao();
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Fisica");
            while (rs.next()) {
                Fisica fis = new Fisica();
                
                fis.setCpf(rs.getString("cpf"));
                fis.setNomeCompleto(rs.getString("nomeCompleto"));
                fis.setSexo(rs.getString("sexo"));
                fis.setDataNascimento(rs.getString("dataNascimento"));
                
                fis.setEmail(rs.getString("email"));
                fis.setTelefoneCel(rs.getString("telefoneCel"));
                fis.setTelefoneFixo(rs.getString("telefoneFixo"));
                
                fis.setLogradouro(rs.getString("logradouro"));
                fis.setNumero(rs.getString("numero"));
                fis.setCep(rs.getString("cep"));
                fis.setComplemento(rs.getString("complemento"));
                fis.setCidade(rs.getString("cidade"));
                fis.setBairro(rs.getString("bairro"));
                fis.setEstado(rs.getString("estado"));
                
                lista.add(fis);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public ArrayList consultar(Fisica fis ) {
        ArrayList<Fisica>fisionario = new ArrayList<Fisica>();
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT * FROM Fisica WHERE  `nomeCompleto` LIKE '%" + fis.getNomeCompleto()
                    + "%' or `matricula`  LIKE '%" + fis.getCpf()+"%'");

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Fisica fisi = new Fisica();
                fisi.setCpf(rs.getString("cpf"));
                fisi.setNomeCompleto(rs.getString("nomeCompleto"));
                fisi.setSexo(rs.getString("sexo"));
                fisi.setDataNascimento(rs.getString("dataNascimento"));
                
                fisi.setEmail(rs.getString("email"));
                fisi.setTelefoneCel(rs.getString("telefoneCel"));
                fisi.setTelefoneFixo(rs.getString("telefoneFixo"));
                
                fisi.setLogradouro(rs.getString("logradouro"));
                fisi.setNumero(rs.getString("numero"));
                fisi.setCep(rs.getString("cep"));
                fisi.setComplemento(rs.getString("complemento"));
                fisi.setCidade(rs.getString("cidade"));
                fisi.setBairro(rs.getString("bairro"));
                fisi.setEstado(rs.getString("estado"));
                
                fisionario.add(fisi);
                
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return fisionario;
    }
    
    public static int exclui(String cpf) {
        int ret = 0;
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "DELETE FROM Fisica WHERE cpf = ?");
            pstm.setString(1, cpf);
            ret = pstm.executeUpdate();
            FisicaDAO.exclui(cpf);
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }
}
