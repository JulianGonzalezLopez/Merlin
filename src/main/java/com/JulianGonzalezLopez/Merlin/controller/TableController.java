/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.controller;

import com.JulianGonzalezLopez.Merlin.exceptions.InvalidInputValueException;
import com.JulianGonzalezLopez.Merlin.service.TableService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author julian.gonzalez
 */

@RestController
@RequestMapping("/table")
public class TableController {
    
    private final TableService tableService;
    
    @Autowired
    public TableController(TableService tableService){
        this.tableService = tableService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<ArrayList<String>> getAll(){
        ArrayList<String> all = tableService.getAll();
        
        return new ResponseEntity<>(all, null, HttpStatus.ACCEPTED);
    }
    
    
    @PostMapping("/")
    //NO PERMITIR ESPACIOS, NOMBRES DE MERLIN NI NUMEROS O CARACTERES ESPECIALES
    public ResponseEntity<String> createTable(
    @RequestBody String tableName){
        
        if(!(tableName instanceof String)){
            throw new InvalidInputValueException("tableName must be of type String");
        }
        if(tableName.length() < 1){
            throw new InvalidInputValueException("tableName must be at least 1 character long");
        }
        if(tableName.length() > 64){
            throw new InvalidInputValueException("tableName must be 64 characters or less");
        }
        
        tableService.createTable(tableName);
        return new ResponseEntity<>("CREATED", null, HttpStatus.ACCEPTED);
    }
    
    @DeleteMapping("/")
    //SI ELIMINAS UNA TABLA 2 VECES TIRA "UNKNOW TABLE"
    public ResponseEntity<String> deleteTable(
    @RequestBody String tableName){
        
        if(!(tableName instanceof String)){
            throw new InvalidInputValueException("tableName must be of type String");
        }
        if(tableName.length() < 1){
            throw new InvalidInputValueException("tableName must be at least 1 character long");
        }
        if(tableName.length() > 64){
            throw new InvalidInputValueException("Invalid tableName");
        }        
                
        tableService.deleteTable(tableName);
        return new ResponseEntity<>("DELETED", null, HttpStatus.ACCEPTED);
    }
}
