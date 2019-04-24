package DAO;

import ConexaoDB.Conexao;
import JavaBeans.Funcionario;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    
    public static int inserir(Funcionario func) {
        int ret = 0;
        //String matricula;
        try {
            Connection conexao = Conexao.criaConexao();
            PreparedStatement pstm = conexao.prepareStatement(
                    "INSERT INTO Funcionario "
                    + "(matricula, senha, cargo, nomeCompleto, cpf"
                    + ", dataAdmissao, logradouro, cep, complemento, "
                    + "bairro, cidade, estado, numero, telefoneCel,"
                    + "telefoneFixo) VALUES "
                    + "(' " + func.getMatricula() + "', " + func.getSenha()
                    + ", '" + func.getCargo() + "', '" + func.getNomeCompleto()
                    + "' , '" + func.getCpf() + "' , '" + func.getDataAdmissao() + "', '"
                    + func.getLogradouro() + "', '" + func.getCep() + "' , '" + func.getComplemento()
                    + "' , '" + func.getBairro() + "' , '" + func.getCidade() + "' , '" + func.getEstado()
                    + "' , '" + func.getNumero() + "' , '" + func.getTelefoneCel() + "' , '" + func.getTelefoneFixo()
                    + "') ");

            pstm.executeUpdate();
            //ResultSet id = pstm.getGeneratedKeys();
            //matricula = id.getString("matricula");
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }

    public static int alterar(Funcionario func) {
        int ret = 0;
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "UPDATE Funcionario SET  `nomeCompleto` = '"+func.getNomeCompleto()+"', "
                            + " `dataAdmissao` = '"+func.getDataAdmissao()+"', "
                            + " `cargo` = '"+func.getCargo()+"', "
                            + " `senha` = '"+func.getSenha()+"', "
                            + " `telefoneCel` = '"+func.getTelefoneCel()+"', "
                            + " `telefoneFixo` = '"+func.getTelefoneFixo()+"', "
                            + " `logradouro` = '"+func.getLogradouro()+"', "
                            + " `numero` = '"+func.getNumero()+"', "
                            + " `complemento` = '"+func.getComplemento()+"', "
                            + " `cidade` = '"+func.getCidade()+"', "
                            + " `cep` = '"+func.getCep()+"', "
                            + " `bairro` = '"+func.getBairro()+"', "
                            + " `estado` = '"+ func.getEstado()+"' "
                            + " WHERE cpf = '"+func.getCpf()+"' OR matricula = '"+func.getMatricula()+"' ");

            ret = pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }
    
    public List<Funcionario> listar() {
        List<Funcionario> lista = new ArrayList<>();
        try {
            Connection cn = Conexao.criaConexao();
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Funcionario");
            while (rs.next()) {
                Funcionario func = new Funcionario();
                
                func.setCpf(rs.getString("cpf"));
                func.setNomeCompleto(rs.getString("nomeCompleto"));
                func.setCargo(rs.getString("cargo"));
                func.setDataAdmissao(rs.getString("dataAdmissao"));
                
                func.setMatricula(rs.getString("matricula"));
                func.setSenha(rs.getString("senha"));
                
                func.setTelefoneCel(rs.getString("telefoneCel"));
                func.setTelefoneFixo(rs.getString("telefoneFixo"));
                
                func.setLogradouro(rs.getString("logradouro"));
                func.setNumero(rs.getString("numero"));
                func.setCep(rs.getString("cep"));
                func.setComplemento(rs.getString("complemento"));
                func.setCidade(rs.getString("cidade"));
                func.setBairro(rs.getString("bairro"));
                func.setEstado(rs.getString("estado"));
                
                lista.add(func);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public ArrayList consultar(Funcionario func ) {
        ArrayList<Funcionario>funcionario = new ArrayList<Funcionario>();
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT * FROM Funcionario WHERE  `nomeCompleto` LIKE '%" + func.getNomeCompleto()
                    + "%' or `matricula`  LIKE '%" + func.getMatricula()
                    + "%' or `cpf`  LIKE '%" + func.getCpf() + "%'");

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Funcionario funci = new Funcionario();
                funci.setCpf(rs.getString("cpf"));
                funci.setNomeCompleto(rs.getString("nomeCompleto"));
                funci.setCargo(rs.getString("cargo"));
                funci.setDataAdmissao(rs.getString("dataAdmissao"));
                
                funci.setMatricula(rs.getString("matricula"));
                funci.setSenha(rs.getString("senha"));
                
                funci.setTelefoneCel(rs.getString("telefoneCel"));
                funci.setTelefoneFixo(rs.getString("telefoneFixo"));
                
                funci.setLogradouro(rs.getString("logradouro"));
                funci.setNumero(rs.getString("numero"));
                funci.setCep(rs.getString("cep"));
                funci.setComplemento(rs.getString("complemento"));
                funci.setCidade(rs.getString("cidade"));
                funci.setBairro(rs.getString("bairro"));
                funci.setEstado(rs.getString("estado"));
                
                funcionario.add(funci);
                
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return funcionario;
    }
    
    public static int exclui(String cpf) {
        int ret = 0;
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "DELETE FROM Funcionario WHERE cpf = ?");
            pstm.setString(1, cpf);
            ret = pstm.executeUpdate();
            FuncionarioDAO.exclui(cpf);
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }
}
