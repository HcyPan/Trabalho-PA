package com.henrique.trabalhopa.controller;

import com.henrique.trabalhopa.pagehandlers.TratadordePagina;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Henrique
 */
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jspURL = "/index.jsp";
        request.setCharacterEncoding("UTF8");
        response.setCharacterEncoding("UTF8");
        System.out.println("Controller");
        try{
            String nomeDoTratadorDePagina = request.getParameter("tratador");
            if(nomeDoTratadorDePagina == null) nomeDoTratadorDePagina = "com.henrique.trabalhopa.pagehandlers.Tratadorpg1";
            
            TratadordePagina tratador = (TratadordePagina) Class.forName(nomeDoTratadorDePagina).newInstance();
            jspURL = tratador.processar(request, response);
        } catch (Exception e) {
            request.setAttribute("EXCESSAO_CONTROLLER", e.toString());
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        } finally {
            response.setContentType("text/html;charset=UTF-8");
            request.getRequestDispatcher(jspURL).forward(request, response);
        }
            
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
