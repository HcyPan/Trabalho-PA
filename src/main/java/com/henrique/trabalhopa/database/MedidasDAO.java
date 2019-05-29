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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Henrique
 */
public class MedidasDAO extends BaseDAO{

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
    
    public ArrayList<MedidasDTO> doRead(String medidor, LocalDate dataInicial, LocalDate dataFinal) throws SQLException{
        Connection con = getConnection();
        MedidasDTO resp = new MedidasDTO();
        try{
            PreparedStatement pstmt = con.prepareStatement(
            "SELECT * FROM "+medidor+""+"WHERE datahora > ? and datahora <?");
            pstmt.setObject(1, dataInicial);
            pstmt.setObject(2, dataFinal);
            ResultSet rstst = pstmt.executeQuery();
            ArrayList<MedidasDTO> lista = new ArrayList();
            while(rstst.next()){
                resp.setSerialNo(rstst.getString(1));
                resp.setMedidor(rstst.getString(2));
                resp.setTemperatura(rstst.getString(3));
                resp.setUmidade(rstst.getString(4));
                resp.setDataHora(rstst.getString(5));
                resp.setSerial(rstst.getString(6));
                lista.add(resp);
                }
            System.out.println("Read");
            return lista;
            }
        catch (Exception e) {
            e.printStackTrace();
            return null;
            }
    }
    
    boolean doUpdate(MedidasDTO dto){
        return true;
    }
    
    boolean doDelete(MedidasDTO dto){
        return true;
    }
}
