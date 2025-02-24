/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin;

import com.JulianGonzalezLopez.Merlin.exceptions.SystemBreakingException;
import java.sql.SQLException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author julian.gonzalez
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler({SystemBreakingException.class})
    public ResponseEntity<String> handleSystemBreakingException(Exception ex){
        System.out.println("well something went really bad :/");
        System.out.println(ex.getCause());
        System.out.println(ex.getMessage());    
        return ResponseEntity
                .status(500)
                .build();
    }

    @ExceptionHandler({SQLException.class})
    public ResponseEntity<?> handleSQLException(Exception ex){
        System.out.println("Something failed");
                return ResponseEntity
                .status(400)
                .build();
    }
}

