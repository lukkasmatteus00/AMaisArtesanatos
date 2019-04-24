package Servlet;

import DAO.FisicaDAO;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deletaFisica extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Exclui Fisica\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String cpf= request.getParameter("cpf");
            
            FisicaDAO dao = new FisicaDAO();
            dao.exclui(cpf);
            
            System.out.println("" + cpf + "excluída com sucesso.");
            response.sendRedirect("sucesso.jsp");

    }
    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet \'Exclui Fisica\' ");
    }
}