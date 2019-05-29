<%@page import="java.net.URL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% URL contexto = new URL(
            //            "https",
            request.getScheme(),
            request.getServerName(),
            request.getServerPort(),
            request.getContextPath());%>

<!DOCTYPE html>
<html>
    <head>
        <script>var contexto = "<%= contexto%>/";</script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina 2</title>
        <link rel="stylesheet" type="text/css" href="<%= contexto%>/css/pagina2.css"/>
        <script type="text/javascript" src="<%= contexto %>/js/pagina2.js"></script>
    </head>

    <body>
        <input type="hidden" name="tratador" value="com.henrique.trabalhopa.pagehandlers.Tratadorpg2"/>

        <h1>Home Automation</h1>
        
        <div id="dialogo">
        </div>
        
        <br>
        
        <div id="divMedidoresCadastrados">
            <h3>Medidores cadastrados</h3>
            <h4><a href="#" style="color:#0044ff">Cadastrar novo medidor</a></h4>
            
            <table id="tabelamedidores">
                <tr>
                    <td>Nome</td>
                    <td>Tabela</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td><input type=text value="Cozinha"/></td>
                    <td>medidor003</td>
                    <td>Editar/Salvar/Excluir</td>
                </tr>
                <tr>
                    <td><input type=text value="Área de serviço"/></td>
                    <td>medidor004</td>
                    <td>Editar/Salvar/Excluir</td>
                </tr>
            </table>
        </div>
        
        
    </body>
</html>
