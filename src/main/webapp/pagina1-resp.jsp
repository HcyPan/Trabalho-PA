<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.henrique.trabalhopa.database.MedidasDTO"%>
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
        <title>Pagina 1</title>
        <link rel="stylesheet" type="text/css" href="<%= contexto%>/css/pagina1.css"/>
        <script type="text/javascript" src="<%= contexto %>/js/pagina1.js"></script>
    </head>

    <body>
        <input type="hidden" name="tratador" value="com.henrique.trabalhopa.pagehandlers.Tratadorpg1"/>

        <h1>Home Automation</h1>
        
        <div id="dialogo">
        </div>
        
        <div id="divComandos">
            <div class="caixas_menu">
                MEDIDOR
                <select id="selectVariaveisDashboard" name="selectVariaveis">
                    <option value="sala" selected>Sala</option>
                    <option value="quarto1">Quarto 1</option>
                    <option value="quarto2">Quarto 2</option>
                    <option value="banheiro">Banheiro</option>
                    <option value="cozinha">Cozinha</option>
                    <option value="areaservico">Área de serviço</option>
                </select>
            </div>
            <div class="caixas_menu">
                PERÍODO
                <select id="selectPeriodo" name="selectPeriodo">
                    <option value="diario">DIÁRIO</option>
                    <option value="semanal">SEMANAL</option>
                    <option value="mensal">MENSAL</option>
                    <option value="anual">ANUAL</option>
                </select>
            </div>
            <div class="caixas_menu">
                DATA FINAL
                <input id="datafinal" type="text" value="20/10/2019"/>
            </div>
            <div class="caixas_menu">
                <span id="labelGrafico">GRÁFICO</span>/<span id="labelTabela" 
                      style="color:lightgrey;">TABELA</span>
                <div id="divextslider">
                    <div id="posGrafico">
                    </div>
                    <div id="posTabela">
                    </div>
                </div>
            </div>
            <div class="caixas_menu">
                <br>
                <a name="BUSCAR" href="#" style="color:#0044ff;">
                    LER/RELER
                </a>
            </div>
        </div>

        <div id="divGraficoTabela">
            <% System.out.println("teste print"); %>
        </div>
    </body>
</html>
