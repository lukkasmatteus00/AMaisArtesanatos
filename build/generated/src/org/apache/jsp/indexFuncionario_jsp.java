package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class indexFuncionario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/menuAdmin.jspf");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"icon\" href=\"images/favicon.ico\">\n");
      out.write("\n");
      out.write("        <title>A + Artesanato</title>\n");
      out.write("        <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js\"></script>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/ie10-viewport-bug-workaround.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"js/ie-emulation-modes-warning.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("<link href=\"css/fale.css\" rel=\"stylesheet\">\n");
      out.write("<nav class=\"navbar navbar-inverse navbar-fixed-top\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"navbar-header\">\n");
      out.write("            <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\n");
      out.write("                <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                <span class=\"icon-bar\"></span>\n");
      out.write("                <span class=\"icon-bar\"></span>\n");
      out.write("                <span class=\"icon-bar\"></span>\n");
      out.write("            </button>\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">Controle do sistema</a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"navbar\" class=\"navbar-collapse collapse\">\n");
      out.write("            <ul class=\"nav navbar-nav\">\n");
      out.write("                <li class=\"active\"><a href=\"indexFuncionario.jsp\">inicio</a></li>\n");
      out.write("                <li class=\"dropdown\">\n");
      out.write("                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Clientes <span class=\"caret\"></span></a>\n");
      out.write("                    <ul class=\"dropdown-menu\">\n");
      out.write("                        <li class=\"dropdown-submenu\">\n");
      out.write("                            <a class=\"test\" tabindex=\"-1\" href=\"#\">Juridica <span class=\"caret\"></span></a>\n");
      out.write("                            <ul class=\"dropdown-menu\">\n");
      out.write("                                <li><a tabindex=\"-1\" href=\"adicionarClienteJuridica.jsp\">Cadastrar</a></li>\n");
      out.write("                                <li><a tabindex=\"-1\" href=\"#\">Consultar</a></li>\n");
      out.write("                                <li><a tabindex=\"-1\" href=\"alteraClienteJuridica.jsp\">Alterar</a></li>\n");
      out.write("                                <li><a tabindex=\"-1\" href=\"#\">Excluir</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                            <a class=\"test\" tabindex=\"-1\" href=\"#\">Fisica <span class=\"caret\"></span></a>\n");
      out.write("                            <ul class=\"dropdown-menu\">\n");
      out.write("                                <li><a tabindex=\"-1\" href=\"adicionarClienteFisica.jsp\">Cadastrar</a></li>\n");
      out.write("                                <li><a tabindex=\"-1\" href=\"#\">Consultar</a></li>\n");
      out.write("                                <li><a tabindex=\"-1\" href=\"alteraClienteFisica.jsp\">Alterar</a></li>\n");
      out.write("                                <li><a tabindex=\"-1\" href=\"#\">Excluir</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"dropdown\">\n");
      out.write("                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Produtos <span class=\"caret\"></span></a>\n");
      out.write("                    <ul class=\"dropdown-menu\">\n");
      out.write("                        <li><a href=\"adicionarProduto.jsp\">Cadastrar</a></li>\n");
      out.write("                        <li><a href=\"consultarProduto.jsp\">Consultar</a></li>\n");
      out.write("                        <li><a href=\"alterarProduto.jsp\">Alterar</a></li>\n");
      out.write("                        <li><a href=\"#\">Excluir</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"dropdown\">\n");
      out.write("                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Funcionários<span class=\"caret\"></span></a>\n");
      out.write("                    <ul class=\"dropdown-menu\">\n");
      out.write("                        <li><a href=\"adicionarFuncionario.jsp\">Cadastrar</a></li>\n");
      out.write("                        <li><a href=\"#\">Consultar</a></li>\n");
      out.write("                        <li><a href=\"alteraFuncionario.jsp\">Alterar</a></li>\n");
      out.write("                        <li><a href=\"#\">Excluir</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li><a href=\"#\">Relatórios</a></li>\n");
      out.write("                <li><a href=\"#\">Vendas</a></li>\n");
      out.write("                <li><a href=\"mensagens.jsp\">Mensagens</a></li>\n");
      out.write("            </ul>\n");
      out.write("            <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                <li><a href=\"#\">SAIR</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</nav>\n");
      out.write("<style>\n");
      out.write("    .dropdown-submenu {\n");
      out.write("        position: relative;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .dropdown-submenu .dropdown-menu {\n");
      out.write("        top: 0;\n");
      out.write("        left: 100%;\n");
      out.write("        margin-top: -1px;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("<script>\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $('.dropdown-submenu a.test').on(\"click\", function (e) {\n");
      out.write("            $(this).next('ul').toggle();\n");
      out.write("            e.stopPropagation();\n");
      out.write("            e.preventDefault();\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("</script>");
      out.write("\n");
      out.write("        <hr class=\"featurette-divider\">\n");
      out.write("        <hr class=\"featurette-divider\">\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-3 col-md-2 sidebar\">\n");
      out.write("                    <ul class=\"nav nav-sidebar\">\n");
      out.write("                        <li class=\"active\"><a href=\"mensagens.jsp\">Mensagens</a></li>\n");
      out.write("                        <li><a href=\"#\">Ajuda</a></li>\n");
      out.write("                        <li><a href=\"#\">Sobre</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"container marketing\">\n");
      out.write("                    <hr class=\"featurette-divider\">\n");
      out.write("                    <div class=\"col-md-7\">\n");
      out.write("                        <button class=\"btn btn-primary \" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapseExample\" aria-expanded=\"false\" aria-controls=\"collapseExample\">\n");
      out.write("                            Escrever uma mensagem\n");
      out.write("                        </button>\n");
      out.write("                        <div class=\"collapse\" id=\"collapseExample\">\n");
      out.write("                            <div class=\"well\">\n");
      out.write("                                <div class=\"container2\">\n");
      out.write("                                    <form method=\"POST\" action=\"addFaleConosco\" class=\"form-signin\">\t\n");
      out.write("                                        \n");
      out.write("                                        <input type=\"text\" name=\"titulo\" class=\"form-control\" placeholder=\"Titulo\" required autofocus />\n");
      out.write("                                        <textarea type=\"text\" rows=\"5\" cols=\"30\" name=\"mensagem\" class=\"form-control\" placeholder=\"Escrever uma mensagem...\" required autofocus ></textarea>\n");
      out.write("\n");
      out.write("                                        <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\">Enviar</button></a>\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n");
      out.write("                <script>window.jQuery || document.write('<script src=\"../../assets/js/vendor/jquery.min.js\"><\\/script>')</script>\n");
      out.write("                <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("                </body>\n");
      out.write("                </html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
