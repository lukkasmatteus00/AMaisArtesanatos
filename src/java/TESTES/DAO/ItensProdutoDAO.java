package TESTES.DAO;

import ConexaoDB.Conexao;
import JavaBeans.Produto;
import JavaBeans.Vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItensProdutoDAO {
  public static List<Vendas> Relatorio(int codigo) {
        List<Vendas> vendass = new ArrayList<Vendas>();
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT * FROM Vendas p INNER JOIN " +
                    "ItensProduto ep ON p.codigo = ep.Vendas_codigo " +
                    "WHERE ep.Produto_idProduto = ?");
            pstm.setInt(1, codigo);
ResultSet rs = pstm.executeQuery();
            vendass = new ArrayList<Vendas>();
                while (rs.next()) {
                    Vendas vendas = new Vendas();
                vendas.setCodigo(rs.getInt("codigo"));
                vendas.setData(rs.getDate("data"));
                vendas.setQuantidade(rs.getInt("quantidade"));
                vendas.setFuncionario(FuncionarioDAO.consultarMatricula(rs.getString("Funcionario_matricula")));
                vendas.setFisica(FisicaDAO.consultarCPF(rs.getString("Fisica_cpf")));
                vendas.setJuridica(JuridicaDAO.consultarCNPJ(rs.getString("Juridica_cnpj")));
                vendass.add(vendas);
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return vendass;
    }
  
public static int inserir( int codigo, List<Vendas> vendas) {
        int ret = 0;
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "INSERT INTO ItensProduto " +
                    "(Vendas_codigo, Produto_idProduto) VALUES (?, ?)");
            pstm.setInt(1, codigo);
            for (Vendas Vendas: vendas) {
                pstm.setInt(2, Vendas.getCodigo());
                ret = pstm.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }

public static int exclui(int idProduto) {
        int ret = 0;
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "DELETE FROM ItensProduto WHERE Produto_idProduto = ?");
            pstm.setInt(1, idProduto);
            ret = pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }

public static int altera(Vendas sale , Produto product) {
        int ret = 0;
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "UPDATE ItensProduto SET Vendas_codigo = ? WHERE Produto_idProduto = ?");
            pstm.setInt(1, sale.getCodigo());
            
            pstm.setInt(2, product.getIdProduto());
            
            ret = pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }

}
