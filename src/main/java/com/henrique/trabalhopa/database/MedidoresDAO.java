/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henrique.trabalhopa.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Henrique
 */
public class MedidoresDAO extends BaseDAO{
    
        public ArrayList<MedidoresDTO> doRead(){
            ArrayList<MedidoresDTO> listademedidores = new ArrayList<>();
            MedidoresDTO dto = new MedidoresDTO();
            Connection con = getConnection();
            try{
                PreparedStatement pstmt;
                pstmt = con.prepareStatement(
                    "SELECT * FROM medidores");
                ResultSet rst = pstmt.executeQuery();
                while(rst.next()){
                    dto.setMedidoresSerialNo(rst.getString(1));
                    dto.setNome(rst.getString(2));
                    dto.setTabela(rst.getString(3));
                    listademedidores.add(dto);
                }
                con.close();
                return listademedidores;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
            
        boolean doCreate(MedidoresDTO dto){
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
         boolean doUpdate(MedidoresDTO dto){
        return true;
    }
    
    boolean doDelete(MedidoresDTO dto){
        return true;
    }
}
