<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="images/favicon.ico">

        <title>A + Artesanato</title>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
        <script src="js/ie-emulation-modes-warning.js"></script>
    </head>
    <body>
        <style>
            .control-label1{
                font-size: 1.2em;
                color: #666;
            }
        </style>
        <%@include file="menuAdmin.jspf" %>
        <%@include file="validaCampos.jspf" %>

        <hr class="featurette-divider">
        <hr class="featurette-divider">
        <form class="form-horizontal" name="CadFunc" action="addFuncionario" method="POST">
            <div class="container marketing">
                <div class="form-group">
                    <div class="col-md-12"><label class="control-label1">Dados Pessoais</label></div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label"  for="textinput">Nome Completo:</label>
                    <div class="col-md-4 col-sm-8">
                        <input id="firstName" name="nomeCompleto" required class="form-control" type="text"  placeholder=""/>
                    </div>

                    <label class="col-md-1 control-label" for="textinput">CPF:</label>
                    <div class="col-md-4 col-sm-8">
                        <input class="form-control" type="text" required name="cpf" onBlur="ValidarCPF(CadFunc.cpf);" 
                               onKeyPress="MascaraCPF(CadFunc.cpf);" maxlength="14" placeholder="000.000.000-00" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label" for="textinput">Data de Admissão:</label>
                    <div class="col-md-4 col-sm-8">
                        <input id="firstName" name="dataAdmissao" class="form-control" type="text"  placeholder="00/00/0000" onKeyPress="MascaraData(CadFunc.dataAdmissao);" 
                               maxlength="10"  onBlur="ValidaData(CadFunc.dataAdmissao);"/>
                    </div>

                    <label class="col-md-1 control-label" for="textinput">Cargo:</label>
                    <div class="col-md-4 col-sm-8">
                        <input id="firstName" name="cargo" required class="form-control" type="text"  placeholder=""/>
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-md-12"><label class="control-label1">Cadastro de Acesso</label></div>
                </div>

                <div class="form-group">
                    <label class="col-md-2 control-label" for="textinput">Matricula:</label>
                    <div class="col-md-2 col-sm-8">
                        <input id="firstName" name="matricula" required class="form-control" type="text"  placeholder="00000-0" 
                               onKeyPress="MascaraMatricula(CadFunc.matricula);" 
                               maxlength="7"/>
                    </div>

                    <label class="col-md-1 control-label" for="textinput">Senha:</label>
                    <div class="col-md-2 col-sm-12">
                        <input id="lastName" name="senha" required class="form-control" type="password" placeholder="" />
                    </div>

                    <label class="col-md-2 control-label" for="textinput">Confirma Senha:</label>
                    <div class="col-md-2 col-sm-12">
                        <input id="lastName" name="confsenha" required class="form-control" type="password" placeholder="" />
                    </div>
                </div>
            </div>



            <div class="container marketing">
                <div class="form-group">
                    <div class="col-md-12"><label class="control-label1">Contatos</label></div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label" for="textinput">Telefone Celular:</label>
                    <div class="col-md-3 col-sm-8">
                        <input id="lastName" name="telefoneCel" required class="form-control"  type="text" placeholder="(00) 0000-0000" onKeyPress="MascaraTelefone(CadFunc.telefoneCel);" 
                               maxlength="14"  onBlur="ValidaTelefone(CadFunc.telefoneCel);" />
                    </div>

                    <label class="col-md-2 control-label" for="textinput">Telefone Fixo:</label>
                    <div class="col-md-3 col-sm-8">
                        <input id="lastName" name="telefoneFixo"  class="form-control" type="text" placeholder="(00) 0000-0000" onKeyPress="MascaraTelefone(CadFunc.telefoneFixo);" 
                               maxlength="14"  onBlur="ValidaTelefone(CadFunc.telefoneFixo);" />
                    </div>
                </div>
            </div>
            <div class="container marketing">
                <div class="form-group">
                    <div class="col-md-12"><label class="control-label1">Endereço</label></div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label" for="textinput">Endereço:</label>
                    <div class="col-md-4 col-sm-8">
                        <input id="firstName" name="logradouro" required class="form-control" type="text"  placeholder=""/>
                    </div>

                    <label class="col-md-1 control-label" for="textinput">Numero:</label>
                    <div class="col-md-1 col-sm-1">
                        <input id="lastName" maxlength="3" name="numero" required class="form-control" type="text" placeholder="" />
                    </div>

                    <label class="col-md-1 control-label" for="textinput">CEP:</label>
                    <div class="col-md-2 col-sm-1">
                        <input id="lastName" name="cep" required class="form-control" type="text" placeholder="00000-000" onKeyPress="MascaraCep(CadFunc.cep);"
                               maxlength="10" onBlur="ValidaCep(CadFunc.cep)" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label" for="textinput">Complemento:</label>
                    <div class="col-md-9 col-sm-8">
                        <input id="firstName" name="complemento" class="form-control" type="text"  placeholder=""/>
                    </div>

                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label" for="textinput">Cidade:</label>
                    <div class="col-md-4 col-sm-8">
                        <input id="firstName" name="cidade" required class="form-control" type="text"  placeholder=""/>
                    </div>

                    <label class="col-md-1 control-label" for="textinput">Bairro:</label>
                    <div class="col-md-2 col-sm-6">
                        <input id="lastName"  name="bairro" required class="form-control" type="text" placeholder="" />
                    </div>

                    <label class="col-md-1 control-label" for="textinput">UF:</label>
                    <div class="col-md-1 col-sm-6">
                        <select id="selectbasic" name="estado" required class="form-control">
                            <option value="...">...</option>
                            <option value="AC">AC</option>
                            <option value="AL">AL</option>
                            <option value="AP">AP</option>
                            <option value="AM">AM</option>
                            <option value="BA">BA</option>
                            <option value="CE">CE</option>
                            <option value="ES">ES</option>
                            <option value="DF">DF</option>
                            <option value="MA">MA</option>
                            <option value="MT">MT</option>
                            <option value="MS">MS</option>
                            <option value="MG">MG</option>
                            <option value="PA">PA</option>
                            <option value="PB">PB</option>
                            <option value="PR">PR</option>
                            <option value="PE">PE</option>
                            <option value="PI">PI</option>
                            <option value="RJ">RJ</option>
                            <option value="RN">RN</option>
                            <option value="RS">RS</option>
                            <option value="RO">RO</option>
                            <option value="RR">RR</option>
                            <option value="SC">SC</option>
                            <option value="SP">SP</option>
                            <option value="SE">SE</option>
                            <option value="TO">TO</option>
                        </select>
                    </div>
                </div>
                <hr class="featurette-divider">
                <div class="form-group">
                    <label class="col-md-4 control-label" for="button1id"></label>
                    <div class="col-md-offset-5">
                        <button id="button1id" name="button1id" type="submit" class="btn btn-primary">Confirmar</button>
                        <button id="button1id" name="button1id" type="reset" class="btn btn-danger">Limpar</button>
                        <a href="cadastroFuncionario.jsp" class="btn btn-default">Cancelar</a>
                    </div>
                </div>
                <hr class="featurette-divider">
            </div>
        </form>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
