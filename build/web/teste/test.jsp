<%-- 
    Document   : test
    Created on : 12/05/2016, 22:53:09
    Author     : BRANCA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%@include file="validaCPF.jspf" %>
        <%@include file="validaCampos.jspf" %>
        <form name="form1">
<br><br>CEP:
<input type="text" name="cep" onKeyPress="MascaraCep(form1.cep);"
 maxlength="10" onBlur="ValidaCep(form1.cep)">
<br><br>DATA:
<input type="text" name="data" onKeyPress="MascaraData(form1.data);"
 maxlength="10" onBlur= "ValidaData(form1.data);">
<br><br>Telefone: 
<input type="text" name="tel" onKeyPress="MascaraTelefone(form1.tel);" 
maxlength="14"  onBlur="ValidaTelefone(form1.tel);">
<br><br>CPF:
<input type="text" name="cpf" onBlur="ValidarCPF(form1.cpf);" 
onKeyPress="MascaraCPF(form1.cpf);" maxlength="14">
<br><br>CNPJ:
<input type="text" name="cnpj" onKeyPress="MascaraCNPJ(form1.cnpj);" 
maxlength="18" onBlur="ValidarCNPJ(form1.cnpj);">
</form>
        
        <input type="text" name="cpf" id="cpf" onblur="javascript: validarCPF(this.value);" onkeypress="javascript: mascara(this, cpf_mask);"  maxlength="14" />
        <label for="rg">RG*</label><br />
<input name="rg" type="text" id="rg" size="30" maxlength="12" onKeyPress="MascaraRG(form1.rg);" />
    </body>
</html>
