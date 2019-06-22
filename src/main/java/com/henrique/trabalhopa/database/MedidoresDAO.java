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

            try{
                ArrayList<MedidoresDTO> listademedidores = new ArrayList<>();
                Connection con = getConnection();
                PreparedStatement pstmt = con.prepareStatement(
                    "SELECT * FROM medidores");
                ResultSet rst = pstmt.executeQuery();
                while(rst.next()){
                    MedidoresDTO dto = new MedidoresDTO();
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
            
    public void doCreate(MedidoresDTO dto){
        try {
            Connection con = getConnection();
            PreparedStatement pstmt;
            pstmt = con.prepareStatement(
                    "INSERT INTO medidor (nome, tabela) VALUES(?,?) RETURNING serialno;");
            pstmt.setString(1, dto.getNome());
            pstmt.setString(2, dto.getTabela());
            ResultSet rst = pstmt.executeQuery();
            rst.next();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void doUpdate(MedidoresDTO dto){
        try{
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(
               "UPDATE medidores SET nome=? WHERE serialno_medidores=?;");
            //pstmt.setString(1, nome);
            //pstmt.setInt(2, Integer.valueOf(serial));
            pstmt.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void doDelete(MedidoresDTO dto){
        try{
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(
               "DELETE FROM medidores WHERE serialno_medidores=?;");
            //pstmt.setInt(1, Integer.valueOf(serial));
            pstmt.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
