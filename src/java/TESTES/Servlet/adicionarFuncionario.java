package TESTES.Servlet;

import DAO.FuncionarioDAO;
import JavaBeans.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class adicionarFuncionario extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Adiciona Pessoa\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nomeCompleto     = request.getParameter("nomeCompleto");
            String cpf              = request.getParameter("cpf");
            String logradouro       = request.getParameter("logradouro");
            String cep              = request.getParameter("cep");
            String complemento      = request.getParameter("complemento");
            String cidade           = request.getParameter("cidade");
            String bairro           = request.getParameter("bairro");
            String estado           = request.getParameter("estado");
            String matricula        = request.getParameter("matricula");
            String senha            = request.getParameter("senha");
            String confsenha        = request.getParameter("senha");
            String cargo            = request.getParameter("cargo");
            String numero           = request.getParameter("numero");
            String dataAdmissao     = request.getParameter("dataAdmissao");
            String telefoneCel      = request.getParameter("telefoneCel");
            String tefoneFixo       = request.getParameter("telefoneFixo");

            if (senha.equals(confsenha)) {
                
                Funcionario func = new Funcionario(matricula, senha, cargo, nomeCompleto,
                        cpf, dataAdmissao, logradouro, cep, complemento, bairro, estado,
                        numero, cidade, telefoneCel, tefoneFixo);

                FuncionarioDAO pd;
                pd = new FuncionarioDAO();
                pd.inserir(func);

                out.println("Funcionario cadastrado com sucesso.");
                response.sendRedirect("sucesso.jsp");
                
            }else{
                out.println("Erro! Senhas não conferem!");
            }
        } catch (Exception e) {
            out.println("Erro ao cadastrar pessoa. " + e);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet \'Adiciona Pessoa\' ");
    }

}
