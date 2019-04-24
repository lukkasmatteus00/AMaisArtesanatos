package Servlet;

import DAO.ProdutoDAO;
import JavaBeans.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class alteraProduto extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Altera Pessoa\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String descricao = request.getParameter("descricao");
            String tipo = request.getParameter("tipo");
            String categoria = request.getParameter("categoria");
            Float preco = Float.valueOf(request.getParameter("preco"));
            String nomeProduto = request.getParameter("nomeProduto");

            int idProduto = Integer.parseInt(request.getParameter("idProduto"));

            Produto produto = new Produto(idProduto, nomeProduto, descricao, tipo, categoria, preco);
            ProdutoDAO pd;
            pd = new ProdutoDAO();
            pd.alterar(produto);
            out.println("Produto alterada com sucesso.");
            response.sendRedirect("sucesso.jsp");

        }
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet \'Altera Pessoa\' ");
    }
}
