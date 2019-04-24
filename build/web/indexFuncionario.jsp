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
        <%@include file="menuAdmin.jspf" %>
        <hr class="featurette-divider">
        <hr class="featurette-divider">

        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar">
                    <ul class="nav nav-sidebar">
                        <li class="active"><a href="mensagens.jsp">Mensagens</a></li>
                        <li><a href="#">Ajuda</a></li>
                        <li><a href="#">Sobre</a></li>
                    </ul>
                </div>
                <div class="container marketing">
                    <hr class="featurette-divider">
                    <div class="col-md-7">
                        <button class="btn btn-primary " type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                            Escrever uma mensagem
                        </button>
                        <div class="collapse" id="collapseExample">
                            <div class="well">
                                <div class="container2">
                                    <form method="POST" action="addFaleConosco" class="form-signin">	
                                        
                                        <input type="text" name="titulo" class="form-control" placeholder="Titulo" required autofocus />
                                        <textarea type="text" rows="5" cols="30" name="mensagem" class="form-control" placeholder="Escrever uma mensagem..." required autofocus ></textarea>

                                        <button class="btn btn-lg btn-primary btn-block" type="submit">Enviar</button></a>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
                <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
                <script src="js/bootstrap.min.js"></script>
                </body>
                </html>
