package com.henrique.trabalhopa.controller;

import com.henrique.trabalhopa.pagehandlers.GenericResponse;
import com.henrique.trabalhopa.pagehandlers.TratadordePagina;
import java.io.IOException;
import java.io.PrintWriter;
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
        request.setCharacterEncoding("UTF8");
        response.setCharacterEncoding("UTF8");
        try{
            String nomeDoTratadorDePagina = request.getParameter("tratador");
            if(nomeDoTratadorDePagina == null) nomeDoTratadorDePagina = "com.henrique.trabalhopa.pagehandlers.Tratadorpg1";
            
            TratadordePagina tratador = (TratadordePagina) Class.forName(nomeDoTratadorDePagina).newInstance();
            
            GenericResponse resp = tratador.processar(request, response);
            String responsePageName = resp.forward;
            System.out.println(responsePageName);
            if(resp.respostaCrua!= null){
                PrintWriter p = response.getWriter();
                p.write(resp.respostaCrua);
                p.flush();
                p.close();
            }
            else{
                request.getRequestDispatcher(responsePageName).forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("EXCESSAO_CONTROLLER", e.toString());
            request.getRequestDispatcher("/pagina1.jsp").forward(request, response);
            e.printStackTrace();
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
