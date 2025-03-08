/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.exceptions;

/**
 *
 * @author Julian
 */
public class SQLExceptionWrapper extends RuntimeException {
    
    private String publicMessage;
    
    public SQLExceptionWrapper(String message, String publicMessage){
        super(message);
        this.publicMessage = publicMessage;
    }

    public String getPublicMessage() {
        return publicMessage;
    }

    public void setPublicMessage(String publicMessage) {
        this.publicMessage = publicMessage;
    }
}
