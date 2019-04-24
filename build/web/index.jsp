<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>A + Artesanato</title>

        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="icon" href="images/favicon.ico">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/about.css" rel="stylesheet">
        <link href="css/relogio.css" rel="stylesheet">
        <link href="css/loginBorder.css" rel="stylesheet">
        <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
        <script src="js/ie-emulation-modes-warning.js"></script>

        
    </head>
    <body onload="digital();">
        
        <section class="loginBorder">
            <div class="login">
                <form class="form-signin" action='login' method='POST'>
                    <h1><b>Seja bem-vindo</b></h1>
                    <label for="inputMatricula" class="sr-only">Matricula</label>
                    <input type="text"  class="form-control" placeholder="Usuário ou Matricula" required autofocus>
                    <label for="inputPassword" class="sr-only">senha</label>
                    <input type="password" id="inputPassword" class="form-control" placeholder="Senha" required>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>

                </form>
            </div>
                <section class="about">
                    <p class="about-author">
                    &copy; 2016 &ndash; <b>A + Artesanatos</b> 
                    <br>Original  <b>Todos os direitos reservados</b>
                </section>
        </section>
        <!--<div id="data">
            <%
                String data;
                SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
                Date dataAtual = new Date(System.currentTimeMillis());
                data = sd.format(dataAtual);
                out.print(data);
            %>
        </div>
        <div id="relogio"></div>

        <div id="ip">
            O IP do visitante é: <%= request.getRemoteAddr()%>
        </div>-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/holder.min.js"></script>
        <script src="js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
