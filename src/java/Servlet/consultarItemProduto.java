package Servlet;

import DAO.ProdutoDAO;
import JavaBeans.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class consultarItemProduto extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Altera Pessoa\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ProdutoDAO prod = new ProdutoDAO();
        String tipo = request.getParameter("valor");
        String categoria = request.getParameter("valor");
        String nomeProduto = request.getParameter("valor");
        Produto product = new Produto(0, nomeProduto,"", tipo, categoria, 0);
        List<Produto> lisProd = prod.consultar(product);
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                + "        <link rel=\"icon\" href=\"images/favicon.ico\">\n"
                + "\n"
                + "        <title>A + Artesanato</title>\n"
                + "        <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js\"></script>\n"
                + "        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n"
                + "        <link href=\"css/funcao.css\" rel=\"stylesheet\">\n"
                + "        <link href=\"css/ie10-viewport-bug-workaround.css\" rel=\"stylesheet\">\n"
                + "        <script src=\"js/ie-emulation-modes-warning.js\"></script>"
                + "<script src=\"js/funcao.js\"></script>");
        out.println("</head>");
        out.println("<body>");
        out.println("<hr class=\"featurette-divider\">\n"
                + "        <hr class=\"featurette-divider\">");
        out.println("<link href=\"css/fale.css\" rel=\"stylesheet\">\n"
                + "<nav class=\"navbar navbar-inverse navbar-fixed-top\">\n"
                + "    <div class=\"container\">\n"
                + "        <div class=\"navbar-header\">\n"
                + "            <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\n"
                + "                <span class=\"sr-only\">Toggle navigation</span>\n"
                + "                <span class=\"icon-bar\"></span>\n"
                + "                <span class=\"icon-bar\"></span>\n"
                + "                <span class=\"icon-bar\"></span>\n"
                + "            </button>\n"
                + "            <a class=\"navbar-brand\" href=\"#\">Controle do sistema</a>\n"
                + "        </div>\n"
                + "        <div id=\"navbar\" class=\"navbar-collapse collapse\">\n"
                + "            <ul class=\"nav navbar-nav\">\n"
                + "                <li class=\"active\"><a href=\"indexProduto.jsp\">inicio</a></li>\n"
                + "                <li class=\"dropdown\">\n"
                + "                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Clientes <span class=\"caret\"></span></a>\n"
                + "                    <ul class=\"dropdown-menu\">\n"
                + "                        <li class=\"dropdown-submenu\">\n"
                + "                            <a class=\"test\" tabindex=\"-1\" href=\"#\">Juridica <span class=\"caret\"></span></a>\n"
                + "                            <ul class=\"dropdown-menu\">\n"
                + "                                <li><a tabindex=\"-1\" href=\"adicionarClienteJuridica.jsp\">Cadastrar</a></li>\n"
                + "                                <li><a tabindex=\"-1\" href=\"#\">Consultar</a></li>\n"
                + "                                <li><a tabindex=\"-1\" href=\"alteraClienteJuridica.jsp\">Alterar</a></li>\n"
                + "                                <li><a tabindex=\"-1\" href=\"#\">Excluir</a></li>\n"
                + "                            </ul>\n"
                + "                            <a class=\"test\" tabindex=\"-1\" href=\"#\">Fisica <span class=\"caret\"></span></a>\n"
                + "                            <ul class=\"dropdown-menu\">\n"
                + "                                <li><a tabindex=\"-1\" href=\"adicionarClienteFisica.jsp\">Cadastrar</a></li>\n"
                + "                                <li><a tabindex=\"-1\" href=\"#\">Consultar</a></li>\n"
                + "                                <li><a tabindex=\"-1\" href=\"alteraClienteFisica.jsp\">Alterar</a></li>\n"
                + "                                <li><a tabindex=\"-1\" href=\"#\">Excluir</a></li>\n"
                + "                            </ul>\n"
                + "                        </li>\n"
                + "                    </ul>\n"
                + "                </li>\n"
                + "                <li class=\"dropdown\">\n"
                + "                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Produtos <span class=\"caret\"></span></a>\n"
                + "                    <ul class=\"dropdown-menu\">\n"
                + "                        <li><a href=\"adicionarProduto.jsp\">Cadastrar</a></li>\n"
                + "                        <li><a href=\"consultarProduto.jsp\">Consultar</a></li>\n"
                + "                        <li><a href=\"alterarProduto.jsp\">Alterar</a></li>\n"
                + "                        <li><a href=\"#\">Excluir</a></li>\n"
                + "                    </ul>\n"
                + "                </li>\n"
                + "                <li class=\"dropdown\">\n"
                + "                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Funcionários<span class=\"caret\"></span></a>\n"
                + "                    <ul class=\"dropdown-menu\">\n"
                + "                        <li><a href=\"adicionarProduto.jsp\">Cadastrar</a></li>\n"
                + "                        <li><a href=\"#\">Consultar</a></li>\n"
                + "                        <li><a href=\"alteraProduto.jsp\">Alterar</a></li>\n"
                + "                        <li><a href=\"#\">Excluir</a></li>\n"
                + "                    </ul>\n"
                + "                </li>\n"
                + "                <li><a href=\"#\">Relatórios</a></li>\n"
                + "                <li><a href=\"#\">Vendas</a></li>\n"
                + "                <li><a href=\"mensagens.jsp\">Mensagens</a></li>\n"
                + "            </ul>\n"
                + "            <ul class=\"nav navbar-nav navbar-right\">\n"
                + "                <li><a href=\"#\">SAIR</a></li>\n"
                + "            </ul>\n"
                + "        </div>\n"
                + "    </div>\n"
                + "</nav>");
        out.println("<div class='container'>");
        out.println("<h2 class='sub-header'>Resultado da consulta</h2>");
        out.println("<div class='table-responsive'>");
        out.println("<table class='table table-striped'>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Nome do produto</th>");
        out.println("<th>Cargo</th>");
        out.println("<th>Tipo</th>");
        out.println("<th>Categoria</th>");
        out.println("<th>Descricao</th>");
        out.println("<th>Preco</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        out.println("<tr>");
        for (Produto p : lisProd) {
            out.println("<td>" + p.getIdProduto() + "</td>");
            out.println("<td>" + p.getNomeProduto() + "</td>");
            out.println("<td>" + p.getTipo() + "</td>");
            out.println("<td>" + p.getCategoria() + "</td>");
            out.println("<td>" + p.getDescricao() + "</td>");
            out.println("<td>" + p.getPreco() + "</td>");
            
            out.println("<td>");
            out.println("<div class='form-group'>");
            out.println("<label class='col-md-4 control-label' ></label>");
            out.println("<div class='col-md-4'>");
            out.println("<a href='alterarProduto.jsp'><button  class='btn btn-warning'>Alterar</button></a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</td>");
            out.println("<td>");
            out.println("<div class='form-group'>");
            out.println("<label class='col-md-4 control-label'></label>");
            out.println("<div class='col-md-4'>");
            out.println("<form  name='ConProd' action='deletaProduto' method='POST'>");
            out.println("<button name='idProduto' value=" + p.getIdProduto() + " class='btn btn-danger'>Excluir</button>");
            out.println("</form>");
            out.println("</div>");
            out.println("</div>");
            out.println("</td>");
            out.println("</tr>");
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet \'Altera Pessoa\' ");
    }

}
