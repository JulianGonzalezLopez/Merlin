/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.exceptions;

/**
 *
 * @author Julian
 */
public class InvalidTableNameException extends RuntimeException {
    public InvalidTableNameException(String message){
        super(message);
    }
}
