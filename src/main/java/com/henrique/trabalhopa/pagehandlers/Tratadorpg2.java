/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henrique.trabalhopa.pagehandlers;

import com.henrique.trabalhopa.database.MedidasDTO;
import com.henrique.trabalhopa.database.MedidoresDAO;
import com.henrique.trabalhopa.database.MedidoresDTO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Henrique
 */
public class Tratadorpg2 implements TratadordePagina {

    @Override
    public GenericResponse processar(HttpServletRequest request, HttpServletResponse response) {
        GenericResponse resp = new GenericResponse();
        String jspURL = "pagina2.jsp";
        MedidoresDAO dao = new MedidoresDAO();
        ArrayList<MedidoresDTO> medidores;
        medidores = dao.doRead();
        BufferedReader br;
        JsonObject jsonObjectDeJava = null;
        try {
            br = new BufferedReader( new  InputStreamReader( request.getInputStream(),"UTF8"));
            String textoDoJson = br.readLine();
            try (   //Converte o string em "objeto json" java
                // Criar um JsonReader.
                JsonReader readerDoTextoDoJson = 
                        Json.createReader(new StringReader(textoDoJson))) {
                // Ler e fazer o parsing do String para o "objeto json" java
                jsonObjectDeJava = readerDoTextoDoJson.readObject();
                // Acabou, então fechar o reader.
        }catch(Exception e){
            e.printStackTrace();
        }

        } catch (IOException ex) {
            Logger.getLogger(Tratadorpg2.class.getName()).log(Level.SEVERE, null, ex);
        }
        MedidoresDTO dto = new MedidoresDTO();
        if(jsonObjectDeJava != null){
            dto.setNome(jsonObjectDeJava.getString("nome"));
            dto.setTabela(jsonObjectDeJava.getString("tabela"));
            dao.doCreate(dto);
        }
        

        resp.respostaCrua = medidores.toString();
        resp.forward = jspURL;
        return resp;
    }
    
}
