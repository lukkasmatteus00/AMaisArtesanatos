package DAO;

import ConexaoDB.Conexao;
import JavaBeans.Produto;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public static int inserir(Produto produto) {
        int ret = 0;
        //int idProduto;
        try {
            Connection conexao = Conexao.criaConexao();
            PreparedStatement pstm = conexao.prepareStatement(
                    "INSERT INTO Produto "
                    + "(descricao, preco, tipo, categoria, nomeProduto) VALUES "
                    + "(' " + produto.getDescricao() + "', " + produto.getPreco()
                    + ", '" + produto.getTipo() + "', '" + produto.getCategoria()
                    + "' , '" + produto.getNomeProduto() + "' )");

            pstm.executeUpdate();
            //ResultSet id = pstm.getGeneratedKeys();
            //idProduto = id.getInt("idProduto");
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
                    "DELETE FROM Produto WHERE idProduto = ?");
            pstm.setInt(1, idProduto);
            ret = pstm.executeUpdate();
            ProdutoDAO.exclui(idProduto);
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }
    
    public static int alterar(Produto produto) {
        int ret = 0;
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "UPDATE `produto` SET `descricao` = '" + produto.getDescricao()
                    + "',`tipo` = '" + produto.getTipo()
                    + "',`categoria` = '" + produto.getCategoria()
                    + "',`preco`= " + produto.getPreco()
                    + ",`nomeProduto` = '" + produto.getNomeProduto()
                    + "' WHERE idProduto = " + produto.getIdProduto());

            ret = pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }

 

    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<>();
        try {
            Connection cn = Conexao.criaConexao();
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM produto");
            while (rs.next()) {
                Produto prod = new Produto();
                prod.setIdProduto(rs.getInt("idProduto"));
                prod.setNomeProduto(rs.getString("nomeProduto"));
                prod.setTipo(rs.getString("tipo"));
                prod.setCategoria(rs.getString("categoria"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setPreco(rs.getFloat("preco"));

                lista.add(prod);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    public ArrayList consultar(Produto product ) {
        ArrayList<Produto> prodts = new ArrayList<Produto>();
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT * FROM produto WHERE  `nomeProduto` LIKE '%" + product.getNomeProduto()
                    + "%' or `categoria`  LIKE '%" + product.getCategoria()
                    + "%' or `tipo`  LIKE '%" + product.getTipo() + "%'");

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("IdProduto"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setTipo(rs.getString("tipo"));
                produto.setCategoria(rs.getString("Categoria"));
                produto.setNomeProduto(rs.getString("nomeProduto"));
                
                prodts.add(produto);
                out.println("ID: "+product.getIdProduto());
                out.println("NOME: "+product.getNomeProduto());
                out.println("TIPO: "+product.getTipo());
                out.println("Categoria: "+product.getCategoria());
                out.println("Preco: "+product.getPreco());
                out.println("Descrição: "+product.getDescricao());
                out.println("//////////////////////////////////////////////////");
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return prodts;
    }
}
/*
   public static List<Produto> relatorio() {
    List<Produto> Produto_list =
            new ArrayList<Produto>();
    try {
        Connection conexao = Conexao.criaConexao();
        Statement stm = conexao.createStatement();
        ResultSet rs = stm.executeQuery(
            "SELECT * FROM Produto");

        Produto_list = new ArrayList<Produto>();

        while (rs.next()) {
            Produto produto = new Produto();
            produto.setIdProduto(rs.getInt("idProduto"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setPreco(rs.getFloat("preco"));
            produto.setTipo(rs.getString("tipo"));
            produto.setCategoria(rs.getString("categoria"));
            produto.setComprimido(
                        ItensProdutoDAO.Relatorio(rs.getInt("codigo")));
                Produto_list.add(produto);
        }
    } catch (SQLException e) {
        System.out.println("Erro de SQL " + e.getMessage());
    }
    return Produto_list;
}
    

    public static Produto consultar() {
        Produto product = new Produto();
        try {
            Connection cn = Conexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT * FROM produto WHERE  `nomeProduto` LIKE '%" + product.getNomeProduto()
                    + "%' or `categoria`  LIKE '%" + product.getCategoria()
                    + "%' or `tipo`  LIKE '%" + product.getTipo() + "% '"+"or `idProduto` LIKE"+product.getIdProduto());

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                product = new Produto();
                product.setIdProduto(rs.getInt("IdProduto"));
                product.setDescricao(rs.getString("descricao"));
                product.setPreco(rs.getFloat("preco"));
                product.setTipo(rs.getString("tipo"));
                product.setCategoria(rs.getString("Categoria"));
                product.setNomeProduto(rs.getString("nomeProduto"));
                while (rs.next()) {
                    product = new Produto();
                    product.setIdProduto(rs.getInt("IdProduto"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return product;
    }
    
   public List<Produto> consultar() throws SQLException {
        ResultSet rs = stm.executeQuery("SELECT * FROM `tccdb`.`produto` WHERE `tipo`");

        List<Produto> prod = new ArrayList<Produto>();

        while (rs.next()) {
            Produto prodr = new Produto();
            prodr.setIdProduto(rs.getInt("idProduto"));
            prodr.setNomeProduto(rs.getString("nomeProduto"));
            prodr.setCategoria(rs.getString("categoria"));
            prodr.setDescricao(rs.getString("descricao"));
            prodr.setPreco(rs.getFloat("preco"));
            prod.add(prodr);
        }

        rs.close();
        return prod;
    }    
    public List<Produto> consultarIntens() {
        List<Produto> lista = new ArrayList<>();
        Produto product = new Produto();
        try {
            Connection cn = Conexao.criaConexao();
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM produto WHERE  `nomeProduto` LIKE '%" + product.getNomeProduto()
                    + "%' or `categoria`  LIKE '%" + product.getCategoria()
                    + "%' or `tipo`  LIKE '%" + product.getTipo() + "% '");
            while (rs.next()) {
                Produto prod = new Produto();
                prod.setIdProduto(rs.getInt("idProduto"));
                prod.setNomeProduto(rs.getString("nomeProduto"));
                prod.setCategoria(rs.getString("categoria"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setPreco(rs.getFloat("preco"));

                lista.add(prod);
            }
            stm.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    */