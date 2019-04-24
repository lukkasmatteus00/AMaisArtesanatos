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
        <form class="form-horizontal" name="CadProd" action="adicionaProduto" method="POST">

            <div class="container marketing">
                <div class="form-group">
                    <div class="col-md-12"><label class="control-label1">Cadastro de produto</label></div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label" for="textinput">Nome:</label>
                    <div class="col-md-4 col-sm-8">
                        <input id="firstName" required name="nomeProduto" class="form-control" type="text"  placeholder=""/>
                    </div>

                    <label class="col-md-1 control-label" for="textinput">Material:</label>
                    <div class="col-md-4 col-sm-12">
                        <input class="form-control" type="text" required name="tipo"  placeholder="" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label" for="textinput">Categoria:</label>
                    <div class="col-md-4 col-sm-8">
                        <input id="firstName" required name="categoria" class="form-control" type="text"  placeholder=""/>
                    </div>

                    <label class="col-md-1 control-label" for="textinput">Preço:</label>
                    <div class="col-md-2 col-sm-12">
                        <input id="lastName" required name="preco" class="form-control" type="text" onBlur="ValidaMoedas(CadProd.preco);" 
                               onKeyPress="MascaraMoedas(CadProd.preco);" maxlength="6" placeholder="R$ 00,00"  />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label" for="textinput">Descrição do produto:</label>
                    <div class="col-md-9 col-sm-12">
                        <input id="firstName" required name="descricao" class="form-control" type="text"  placeholder=""/>
                    </div>
                </div>
                <hr class="featurette-divider">
                <div class="form-group">
                    <label class="col-md-4 control-label" for="button1id"></label>
                    <div class="col-md-offset-5">
                        <button id="button1id" name="button1id" type="submit" class="btn btn-primary">Confirmar</button>
                        <button class="btn btn-danger" type="reset">Limpar</button>
                        <a href="indexFuncionario.jsp" class="btn btn-default">Cancelar</a>
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
