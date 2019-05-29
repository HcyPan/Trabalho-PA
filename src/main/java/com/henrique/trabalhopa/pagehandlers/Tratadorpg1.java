/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henrique.trabalhopa.pagehandlers;

import com.henrique.trabalhopa.database.MedidasDTO;
import com.henrique.trabalhopa.database.MedidasDAO;
import com.henrique.trabalhopa.database.MedidoresDAO;
import com.henrique.trabalhopa.database.MedidoresDTO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Henrique
 */
public class Tratadorpg1 implements TratadordePagina{
    
    @Override
    public String processar(HttpServletRequest request, HttpServletResponse response) {
        String jspURL = "pagina1.jsp";
        MedidasDAO medidasDAO = new MedidasDAO();
        MedidoresDAO medidoresDAO = new MedidoresDAO();
        String acao = request.getParameter("action");
        switch(acao){
            case "search":
                String medidor = request.getParameter("selectVariaveis");
                String tempo = request.getParameter("selectPeriodo");
                DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyy");
                LocalDate dataFinal = LocalDate.parse(request.getParameter("dataFinal"), formatadorData);
                LocalDate dataInicial = null;
                switch(tempo){
                    case "diaio":
                        dataInicial = dataFinal.minusDays(1);
                        break;
                    case "semanal":
                        dataInicial = dataFinal.minusWeeks(1);
                        break;
                    case "mensal":
                        dataInicial = dataFinal.minusMonths(1);
                        break;
                    case "anual":
                        dataInicial = dataFinal.minusYears(1);
                        break;
                }
            ArrayList<MedidasDTO> medidas = null;
            try {
                medidas = medidasDAO.doRead(medidor, dataInicial, dataFinal);
            } catch (SQLException ex) {
                Logger.getLogger(Tratadorpg1.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getSession().setAttribute("medidas", medidas);
            
            request.getSession().setAttribute("selectVariaveis", medidor);
            request.getSession().setAttribute("selectPeriodo", tempo);
            request.getSession().setAttribute("dataFinal", dataFinal);
            
            ArrayList<MedidoresDTO> medidores = medidoresDAO.doRead();
            request.getSession().setAttribute("medidores", medidores);
            break;

        default:
            request.getSession().removeAttribute("medidas");
            medidores = medidoresDAO.doRead();
            request.getSession().setAttribute("medidores", medidores);
        }
        return jspURL;
    }
}
//System.out.println("tratador da pagina 1");
 
    

