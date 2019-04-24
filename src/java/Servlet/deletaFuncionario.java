package Servlet;

import DAO.FuncionarioDAO;
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

public class deletaFuncionario extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Exclui Produto\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String cpf= request.getParameter("cpf");
            
            FuncionarioDAO dao = null;
            dao = new FuncionarioDAO();
            dao.exclui(cpf);
            
            System.out.println("" + cpf + "excluída com sucesso.");
            response.sendRedirect("sucesso.jsp");

    }
    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet \'Exclui Produto\' ");
    }
}