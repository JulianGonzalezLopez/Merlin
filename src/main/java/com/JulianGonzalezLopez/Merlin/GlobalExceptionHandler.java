/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin;

import com.JulianGonzalezLopez.Merlin.exceptions.InvalidInputValueException;
import com.JulianGonzalezLopez.Merlin.exceptions.InvalidTableNameException;
import com.JulianGonzalezLopez.Merlin.exceptions.SQLExceptionWrapper;
import com.JulianGonzalezLopez.Merlin.exceptions.SystemBreakingException;
import java.sql.SQLException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author julian.gonzalez
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    private final ApplicationContext applicationContext;

    public GlobalExceptionHandler(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }
    
    @ExceptionHandler({SystemBreakingException.class})
    public ResponseEntity<String> handleSystemBreakingException(Exception ex){  
        //No tengo idea que hace, en teoria deberia matar la aplicacion si ocurre un problemon
        new Thread(() -> applicationContext.publishEvent(new ContextClosedEvent(applicationContext))).start();
        return new ResponseEntity<>(ex.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({SQLExceptionWrapper.class})
    public ResponseEntity<?> handleSQLException(SQLExceptionWrapper ex){
        System.out.println("Something failed");
        System.out.println(ex.getMessage());
        return new ResponseEntity<>(ex.getPublicMessage() , null, HttpStatus.BAD_REQUEST);
    }    
    
    //SHOULD NEVER BE CALLED, THE WRAPPER EXISTS FOR A REASON
    @ExceptionHandler({SQLException.class})
    public ResponseEntity<?> handleSQLException(Exception ex){
        System.out.println("Something failed");
        return new ResponseEntity<>(ex.getMessage(), null, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler({InvalidTableNameException.class})
    public ResponseEntity<String> handleInvalidTableNameException(Exception ex){
        return new ResponseEntity<>(ex.getMessage(), null, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler({InvalidInputValueException.class})
    public ResponseEntity<String> handleInvalidInputValueException(Exception ex){
        return new ResponseEntity<>(ex.getMessage(), null, HttpStatus.BAD_REQUEST);
    }
}

