package Servlet;

import DAO.JuridicaDAO;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deletaJuridica extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Exclui Fisica\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String cnpj= request.getParameter("cnpj");
            
            JuridicaDAO dao = new JuridicaDAO();
            dao.exclui(cnpj);
            
            System.out.println("" + cnpj + "excluída com sucesso.");
            response.sendRedirect("sucesso.jsp");

    }
    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet \'Exclui Fisica\' ");
    }
}