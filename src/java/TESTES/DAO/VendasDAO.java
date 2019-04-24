package TESTES.DAO;

import ConexaoDB.Conexao;
import JavaBeans.Vendas;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VendasDAO {
    public static List<Vendas> relatorio() {
    List<Vendas> Vendas_list =
            new ArrayList<Vendas>();
    try {
        Connection conexao = Conexao.criaConexao();
        Statement stm = conexao.createStatement();
        ResultSet rs = stm.executeQuery(
            "SELECT * FROM Vendas");

        Vendas_list = new ArrayList<Vendas>();

        while (rs.next()) {
            Vendas vendas = new Vendas();
            vendas.setCodigo(rs.getInt("codigo"));
            vendas.setData(rs.getDate("data"));
            vendas.setQuantidade(rs.getInt("Quatidade"));
            vendas.setValorTotal(rs.getDouble("valorTotal"));
            vendas.setFuncionario(FuncionarioDAO.consultarMatricula(rs.getString("Funicionario_matricula")));
            vendas.setFisica(FisicaDAO.consultarCPF(rs.getString("Fisica_cpf")));
            vendas.setJuridica(JuridicaDAO.consultarCNPJ(rs.getString("Juridica_cnpj")));
            Vendas_list.add(vendas);
        }
    } catch (SQLException e) {
        System.out.println("Erro de SQL " + e.getMessage());
    }
    return Vendas_list;
}
 
public static int inserir(Vendas vendas) {
    int ret = 0;
    try {
            Connection conexao = Conexao.criaConexao();
            PreparedStatement pstm = conexao.prepareStatement(
                    "INSERT INTO Vendas (codigo, data, quantidade, valorTotal, Funcionario_matricula, Fisica_cpf, Juridica_cnpj) VALUES (?,?,?,?,?,?,?)");
            pstm.setInt(1, vendas.getCodigo());
            pstm.setDate(2, (Date) vendas.getData());
            pstm.setInt(3, vendas.getQuantidade());
            pstm.setDouble(4, vendas.getValorTotal());
            pstm.setString(5, vendas.getFuncionario().getMatricula());
            pstm.setString(6, vendas.getFisica().getCpf());
            pstm.setString(7, vendas.getJuridica().getCnpj());
            ret = pstm.executeUpdate();
         } catch (SQLException e) {
        System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }

public static int exclui(int codigo) {
    int ret = 0;
    try {
        Connection cn = Conexao.criaConexao();
        PreparedStatement pstm = cn.prepareStatement(
                "DELETE FROM Vendas WHERE codigo = ?");
        pstm.setInt(1, codigo);
        ret = pstm.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Erro de SQL: " + e.getMessage());
    }
    return ret;
}

public static Vendas consultarId (int codigo) {
        Vendas Sale = new Vendas();
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT * FROM Vendas WHERE codigo = ?");
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                Sale = new Vendas();
            Sale.setCodigo(rs.getInt("codigo"));
            Sale.setData(rs.getDate("data"));
            Sale.setQuantidade(rs.getInt("quantidade"));
            Sale.setValorTotal(rs.getDouble("valorTotal"));
            Sale.setFuncionario(FuncionarioDAO.consultarMatricula(rs.getString("matricula")));
            Sale.setFisica(FisicaDAO.consultarCPF(rs.getString("cpf")));
            Sale.setJuridica(JuridicaDAO.consultarCNPJ(rs.getString("cnpj")));
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Sale;
    }


 public static int alterar(Vendas vendas) {
        int ret = 0;
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "UPDATE Vendas SET data = ?, quantidade = ?  WHERE codigo = ?");
            pstm.setDate(1, (Date) vendas.getData());
            pstm.setInt(2, vendas.getQuantidade());
            
            pstm.setInt(3, vendas.getCodigo());
            ret = pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    } 
}


