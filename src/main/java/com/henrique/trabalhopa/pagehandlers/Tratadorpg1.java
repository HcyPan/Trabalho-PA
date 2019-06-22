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
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.json.*;
import javax.servlet.ServletException;

/**
 *
 * @author Henrique
 */
public class Tratadorpg1 implements TratadordePagina{
    
    @Override
    public GenericResponse processar(HttpServletRequest request, HttpServletResponse response) {
        GenericResponse resp = new GenericResponse();
        String jspURL = "pagina1.jsp";
        MedidasDAO medidasDAO = new MedidasDAO();
        MedidoresDAO medidoresDAO = new MedidoresDAO();
        String acao = request.getParameter("action");
        ArrayList<MedidoresDTO> medidores;
        medidores = medidoresDAO.doRead();

        if(acao.equals("search")){
            response.setContentType("text/plain");
            System.out.println("Ação selecionada");
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
            ArrayList<MedidasDTO> medidas = new ArrayList();
            try {
                medidas = medidasDAO.doRead(medidor, dataInicial, dataFinal);
            } catch (SQLException ex) {
                Logger.getLogger(Tratadorpg1.class.getName()).log(Level.SEVERE, null, ex);
            }
            resp.respostaCrua = medidas.toString();
            
//            request.getSession().setAttribute("medidas", medidas);
//            request.getSession().setAttribute("selectVariaveis", medidor);
//            request.getSession().setAttribute("selectPeriodo", tempo);
//            request.getSession().setAttribute("dataFinal", dataFinal);
        }
        else if(acao.equals("load")){
            resp.respostaCrua = medidores.toString();
        }
        else{
            System.out.println("Ação default selecionada");
            request.getSession().removeAttribute("medidas");
            try {
                request.getRequestDispatcher("/pagina1.jsp").forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(Tratadorpg1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Tratadorpg1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        resp.forward = jspURL;
        return resp;
    }
}
//System.out.println("tratador da pagina 1");
 
    

