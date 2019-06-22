/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henrique.trabalhopa.database;

import java.io.Serializable;
import java.sql.Date;
import javax.json.Json;
import javax.json.JsonObject;
/**
 *
 * @author Henrique
 */
public class MedidasDTO implements Serializable {
    
    private String serialNo;
    private String medidor;
    private String temperatura;
    private String umidade;
    private String dataHora;
    private String serial;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
    
    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getMedidor() {
        return medidor;
    }

    public void setMedidor(String medidor) {
        this.medidor = medidor;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getUmidade() {
        return umidade;
    }

    public void setUmidade(String umidade) {
        this.umidade = umidade;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
    
    JsonObject objetoJSON;
    
    public JsonObject getObjetoJSON() {
        return objetoJSON;
    }

    public void setObjetoJSON(JsonObject objetoJSON) {
        this.objetoJSON = objetoJSON;
    }
    
    public JsonObject toJSON(){

        objetoJSON = Json.createObjectBuilder()
                .add("serialNo", serialNo)
                .add("medidor", medidor)
                .add("temperatura", temperatura)
                .add("umidade", umidade)
                .add("dataHora", dataHora)
                .add("serial", serial)
                .build();
        
        return objetoJSON;
    }
    
    @Override
    public String toString(){
        return toJSON().toString();
    }

}