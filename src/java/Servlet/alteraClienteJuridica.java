package Servlet;

import JavaBeans.Juridica;
import TESTES.DAO.JuridicaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class alteraClienteJuridica extends HttpServlet {

   @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Adiciona Produto\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String razaoSocial     = request.getParameter("razaoSocial");
            String email            = request.getParameter("email");
            String cnpj              = request.getParameter("cnpj");
            String logradouro       = request.getParameter("logradouro");
            String cep              = request.getParameter("cep");
            String complemento      = request.getParameter("complemento");
            String cidade           = request.getParameter("cidade");
            String bairro           = request.getParameter("bairro");
            String estado           = request.getParameter("estado");
            String numero           = request.getParameter("numero");
            String telefoneCel      = request.getParameter("telefoneCel");
            String tefoneFixo       = request.getParameter("telefoneFixo");
            
                Juridica jur = new Juridica(cnpj, razaoSocial, email, cep, 
                        logradouro, complemento, bairro, cidade, estado, 
                        numero, telefoneCel, tefoneFixo);

                JuridicaDAO pd = new JuridicaDAO();
                pd.alterar(jur);

                out.println("Juridica cadastrado com sucesso.");
                    response.sendRedirect("sucesso.jsp");
        }
    }
    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet \'Adiciona Produto\' ");
    }

}
