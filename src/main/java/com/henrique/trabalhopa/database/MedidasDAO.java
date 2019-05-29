/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henrique.trabalhopa.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Henrique
 */
public class MedidasDAO extends BaseDAO{
    
    public List<MedidasDTO> lista = new ArrayList<MedidasDTO>();    

    boolean doCreate(MedidasDTO dto){
//        try {
//            Connection con = getConnection();
//            PreparedStatement pstmt;
//            pstmt = con.prepareStatement(
//                    "INSERT INTO medidor (medidor) VALUES(?) RETURNING serialno;");
//            pstmt.setString(1, dto.getMedidor());
//            ResultSet rst = pstmt.executeQuery();
//            rst.next();
//            dto.setSerialNo(rst.getString("serialno"));
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
        return true;
    }
    
    public List<MedidasDTO> doRead(String medidor) throws SQLException{
        Connection con = getConnection();
        PreparedStatement pstmt;
        MedidasDTO resp = new MedidasDTO();

        try{
            pstmt = con.prepareStatement(
            "SELECT * FROM medidor001");
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                resp.setDataHora(rst.getDate("datahora"));
                resp.setMedidor(rst.getString("medidor"));
                resp.setTemperatura(rst.getFloat("temperatura"));
                resp.setUmidade(rst.getInt("umidade"));
                resp.setSerialNo(rst.getInt("serialno"));
                lista.add(resp);
                }
            }
        catch (Exception e) {
            e.printStackTrace();
            }
        finally {
            if(con!=null){
                try{
                    con.close();
                    }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Read");
        return lista;
    }
    
    boolean doUpdate(MedidasDTO dto){
        return true;
    }
    
    boolean doDelete(MedidasDTO dto){
        return true;
    }
}
