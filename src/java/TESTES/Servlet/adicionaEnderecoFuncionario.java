package TESTES.Servlet;

import TESTES.DAO.EnderecoDAO;
import TESTES.DAO.FuncionarioDAO;
import JavaBeans.Endereco;
import JavaBeans.Funcionario;
import JavaBeans.Telefone;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class adicionaEnderecoFuncionario extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Adiciona Pessoa\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String endereco     = request.getParameter("endereco");
        String cep          = request.getParameter("cep");
        String referencia   = request.getParameter("referencia");
        String tipoEndereco = request.getParameter("tipoEndereco");
        String cidade       = request.getParameter("cidade");
        String bairro       = request.getParameter("bairro");
        String estado       = request.getParameter("estado");
        String numero       = request.getParameter("numero");
        
            Endereco end = new Endereco (0, tipoEndereco, cep, endereco, referencia, bairro, cidade, estado, numero ); 
        
        EnderecoDAO pd;
        pd = new EnderecoDAO();
        pd.inserir(end);
        
        System.out.println("Funcionario cadastrado com sucesso.");
        response.sendRedirect("adicionarFuncionario.jsp");
        
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet \'Adiciona Pessoa\' ");
    }

}
