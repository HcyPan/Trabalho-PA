<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.henrique.trabalhopa.database.MedidoresDTO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.henrique.trabalhopa.database.MedidasDTO"%>
<%@page import="java.net.URL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
        

            <h1>Home Automation</h1>
            <a href="pagina2.jsp" target="_parent"><button>Medidores</button></a>
            <div id="dialogo">
            </div>
            <form id="form1" method="GET" action="controller">
                <input type="hidden" name="tratador" value="com.henrique.trabalhopa.pagehandlers.Tratadorpg1"/>
                <input type="hidden" name="action" value="search"/>
                <div id="divComandos">
                    <div class="caixas_menu">
                    MEDIDOR
                    <select id="selectVariaveisDashboard" name="selectVariaveis">
                        
                    </select>
                </div>
                <div class="caixas_menu">
                    PERÍODO
                    <select id="selectPeriodo" name="selectPeriodo">
                        <!-- <option value="diario">DIÁRIO</option>
                        <option value="semanal">SEMANAL</option>
                        <option value="mensal">MENSAL</option>
                        <option value="anual">ANUAL</option> -->
                        <%
                        Map<String, String> mapa = new HashMap<>();
                        mapa.put("diario", "DIÁRIO");
                        mapa.put("semanal", "SEMANAL");
                        mapa.put("mensal", "MENSAL");
                        mapa.put("anual", "ANUAL");
                        
                        String tempo = (String) request.getSession().getAttribute("selectPeriodo");
                        if(tempo == null) tempo = "diario";
                        
                        for (Map.Entry<String, String> entry : mapa.entrySet()) {
                            %>
                            <option value="<%= entry.getKey() %>" <% if(entry.getKey().equals(tempo)) out.print("selected"); %>><%= entry.getValue() %></option>
                            <%
                        }
                    %>
                    </select>
                </div>
                <div class="caixas_menu">
                    DATA FINAL
                    <input id="datafinal" name="dataFinal" type="text" value="20/10/2019"/>
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
                    <a name="BUSCAR" href="#" style="color:#0044ff;" onclick="lerReler()">
                        LER/RELER
                    </a>
                </div>
            </div>
         </form>

            <div id="divGraficoTabela" class="flex-container">
            <table id="resultado" class="content" align="center" valign="top">
                <tr>
                    <td>Serialno</td>
                    <td>Medidor</td>
                    <td>Temperatura</td>
                    <td>Umidade</td>
                    <td>Datahora</td>
                    <td>Serial</td>
                </tr>
                </table>
            </div>
    </body>
</html>
