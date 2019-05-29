/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henrique.trabalhopa.database;

import java.io.Serializable;


/**
 *
 * @author Henrique
 */
public class MedidoresDTO implements Serializable{
    
    private String medidoresSerialNo;
    private String nome;
    private String tabela;

    public String getMedidoresSerialNo() {
        return medidoresSerialNo;
    }

    public void setMedidoresSerialNo(String medidoresSerialNo) {
        this.medidoresSerialNo = medidoresSerialNo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }
    
    
}
