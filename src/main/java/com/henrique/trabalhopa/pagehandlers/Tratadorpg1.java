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
        MedidasDAO medidasDAO = new MedidasDAO();
        List<MedidasDTO> listaDeMedidas = new ArrayList<>();
        String medidor = request.getParameter("selectVariaveis");
        MedidoresDAO medidoresDAO = new MedidoresDAO();
        ArrayList<MedidoresDTO> listaDeMedidores = new ArrayList<>();
        try {
            listaDeMedidores = medidoresDAO.doRead();
            request.getSession().setAttribute("listademedidores", listaDeMedidores);
            if(medidor.equals("sala")){
                listaDeMedidas = medidasDAO.doRead(medidor);
                request.getSession().setAttribute("resposta", listaDeMedidas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tratadorpg1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("PageHandler");

        return "/pagina1-resp.jsp";
    }
//System.out.println("tratador da pagina 1");
 
    
}
