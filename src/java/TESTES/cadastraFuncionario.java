package TESTES;

import TESTES.DAO.FuncionarioDAO;
import JavaBeans.Endereco;
import JavaBeans.Funcionario;
import JavaBeans.Telefone;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static sun.security.jgss.GSSUtil.login;

public class cadastraFuncionario extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Adiciona Pessoa\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nomeCompleto, cpf, telefone, endereco, cep, 
                referencia, tipoEndereco, cidade, bairro, 
                estado, usuario, senha, matricula, cargo;
        
        nomeCompleto = request.getParameter("nomeCompleto");
        cpf = request.getParameter("cpf");
        telefone = request.getParameter("telefone");
        endereco = request.getParameter("endereco");
        cep = request.getParameter("cep");
        referencia = request.getParameter("referencia");
        tipoEndereco = request.getParameter("tipoEndereco");
        cidade = request.getParameter("cidade");
        bairro = request.getParameter("bairro");
        estado = request.getParameter("estado");
        usuario = request.getParameter("usuario");
        matricula = request.getParameter("matricula");
        senha = request.getParameter("senha");
        cargo = request.getParameter("cargo");
        int numero = Integer.valueOf(request.getParameter("numero"));
        //Date dataAdmissao = new Date(request.getParameter("dataAdmissao"));
        
        PrintWriter out = response.getWriter();
        out.println("Nome: " + nomeCompleto + "<br/> CPF: "+ 
                cpf + "<br/> Data Admissao: " + "<br/> Telefone: " + telefone+"<br>"
                + "Endereco " + endereco +"<br>"+ numero+"<br>"+cep+"<br>"+referencia+"<br>"+tipoEndereco+"<br>"+cidade+"<br>"+bairro+"<br>"+estado+"<br>"+usuario+"<br>"+senha+"<br>"+matricula+"<br>"+cargo);
        
        
        
        /*Funcionario funcionario = new Funcionario(matricula, usuario, senha, cargo, nomeCompleto, cpf, dataAdmissao,
                new Telefone (0,telefone),
                    new Endereco (0, tipoEndereco, cep, endereco, referencia, bairro, cidade, estado, numero)); 
        
        FuncionarioDAO pd;
        pd = new FuncionarioDAO();
        pd.inserir(funcionario);
        
        System.out.println("Funcionario cadastrado com sucesso.");
        response.sendRedirect("sucesso.jsp");*/
        
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet \'Adiciona Pessoa\' ");
    }

}
