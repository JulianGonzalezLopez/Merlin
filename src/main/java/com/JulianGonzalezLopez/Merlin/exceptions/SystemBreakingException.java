/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.exceptions;

/**
 *
 * @author julian.gonzalez
 */
public class SystemBreakingException extends RuntimeException {
    
    Exception originalException;
    
    public SystemBreakingException(String message, Exception originalException){
        super(message);
        this.originalException = originalException;
    }    
}
