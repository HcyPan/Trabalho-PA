/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henrique.trabalhopa.pagehandlers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Henrique
 */
public interface TratadordePagina {
    public String processar(HttpServletRequest request, HttpServletResponse response);
}
