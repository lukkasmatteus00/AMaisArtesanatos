
package Servlet;

import DAO.FaleConoscoDAO;
import JavaBeans.FaleConosco;
import JavaBeans.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class addFaleConosco extends HttpServlet {

     @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Falando entra funcionarios\'");
    }

   
    protected void service(HttpServletRequest request, HttpServletResponse response, Funcionario Funcionario_matricula)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String titulo      = request.getParameter("titulo");
            String mensagem    = request.getParameter("mensagem");
            
                FaleConosco fale;
            fale = new FaleConosco(0, titulo, mensagem, Funcionario_matricula);

                FaleConoscoDAO pd = new FaleConoscoDAO();
                pd.inserir(fale);

                out.println("Mensagem enviada  com sucesso.");
                    response.sendRedirect("sucesso.jsp");
        }
    }
    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet \'Comentario\' ");
    }
}
