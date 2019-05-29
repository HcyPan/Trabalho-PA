/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henrique.trabalhopa.database;

import  java.sql.Connection;
import javax.naming.InitialContext;
import javax.sql.DataSource;


/**
 *
 * @author Henrique
 */
public class BaseDAO {
    
    private DataSource ds;

    public DataSource getDs() {
        return ds;
    }

    public void setDs(DataSource ds) {
        this.ds = ds;
    }
    
      public BaseDAO() {
        try {
            InitialContext cxt = new InitialContext();
            if (cxt == null) {
                System.out.println("[BaseDAO.constructor] Falha no InitialContext.");
            }else{
                ds = (DataSource) cxt.lookup("java:comp/env/jdbc/nomeDeFantasia");
            }
        } catch (Exception e) {
            System.out.println("[BaseDAO.constructor] Excessão: " + e.getMessage());
        }
    }
    public Connection getConnection(){
        try{
            if(ds!=null){
                return ds.getConnection();
            }else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
