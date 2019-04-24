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

        <hr class="featurette-divider">
        <hr class="featurette-divider">
        <%--<form class="form-horizontal" name="ConProd" action="consultaProduto" method="POST">

            <div class="container marketing">
                <div class="form-group">
                    <div class="col-md-12"><label class="control-label1">Consulta de produtos</label></div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label" for="textinput">Consulta:</label>
                    <div class="col-md-2 col-sm-8">
                        <input id="firstName" name="tipo" class="form-control" type="text"  placeholder="Tipo"/>
                    </div>
                    <div class="col-md-2 col-sm-8">
                        <input id="firstName" name="categoria" class="form-control" type="text"  placeholder="Categoria"/>
                    </div>
                    <div class="col-md-3 col-sm-8">
                        <input id="firstName" name="descricao" class="form-control" type="text"  placeholder="Descrição"/>
                    </div>
                    <div class="col-md-2 col-sm-12">
                        <button id="button1id" name="button1id" type="submit" class="btn btn-primary">Consultar</button>
                    </div>
                </div>


            </div>
        </form>--%>


        <div class="container marketing">
            <div class="form-group">
                <div class="col-md-10">
                    <label class="control-label1">Consulta de produtos</label>
                </div>
            </div>
            <div class="form-group">
                <form class="form-horizontal" name="ConProd" action="consultarItemProduto" method="POST">
                    <div class="col-md-7 col-sm-7">
                        <div class="input-group">
                            <input type="text" name="valor" class="form-control" placeholder="Nome , Tipo ou Categoria">
                            <span class="input-group-btn">
                                <button class="btn btn-info" type="submit">OK</button>
                            </span>
                        </div>
                    </div>
                </form>
               <div class="container marketing">
            <div class="form-group">
                <div class="col-md-offset-7 ">
                    <label class="col-md-offset-1 control-label" ></label>
                    <div class="col-md-1">
                        <a class="btn btn-primary" href="adicionarProduto.jsp" role="button">Novo produto</a>
                    </div>
                    <label class="col-md-4 control-label" ></label>
                    <div class="col-md-4">
                        <a class="btn btn-primary" href="consultaProduto" role="button">Listar todos os produtos</a>
                    </div>
                    </div>
            </div>
            </div>
        </div>
        </div>
        </div>
        <hr class="featurette-divider">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
