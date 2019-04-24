package TESTES.Servlet;

import TESTES.DAO.TelefoneDAO;
import JavaBeans.Funcionario;
import JavaBeans.Telefone;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class adicionarTelefone extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Adiciona Pessoa\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String numero = request.getParameter("numero");
        
        Telefone Tel = new Telefone(0, numero,
        new Funcionario()); 
        
        TelefoneDAO pd;
        pd = new TelefoneDAO();
        pd.inserir(Tel);
        
        System.out.println("Funcionario cadastrado com sucesso.");
        response.sendRedirect("sucesso.jsp");
        
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet \'Adiciona Pessoa\' ");
    }

}
