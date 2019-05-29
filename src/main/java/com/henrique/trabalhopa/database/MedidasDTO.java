/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henrique.trabalhopa.database;

import java.io.Serializable;
import java.sql.Date;
/**
 *
 * @author Henrique
 */
public class MedidasDTO implements Serializable {
    
    private int serialNo;
    private String medidor;
    private float temperatura;
    private int umidade;
    private Date dataHora;

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public String getMedidor() {
        return medidor;
    }

    public void setMedidor(String medidor) {
        this.medidor = medidor;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public int getUmidade() {
        return umidade;
    }

    public void setUmidade(int umidade) {
        this.umidade = umidade;
    }

    public Date getDataHora() {
        return dataHora;
    }
    
    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
}

