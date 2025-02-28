/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianGonzalezLopez.Merlin.table;

import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    
    public ResponseEntity<ArrayList<String>> getAll() throws SQLException {
        ArrayList<String> all = tableService.getAll();
        
        return new ResponseEntity<>(all, null, HttpStatus.ACCEPTED);
    }
    
    
    @PostMapping("/")
    public ResponseEntity<String> createTable(
    @RequestBody String tableName){
        
        try{
        //TYPE ERRORS
        if(!(tableName instanceof String)){
            throw new Error("tableName must be of type String");
        }
        
        //CONTENT ERRORS
        if(tableName.length() < 1){
            throw new Error("tableName must be at least 1 character long");
        }

        }
        catch(Error e){
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.BAD_REQUEST);
        }
                 
        //NORMAL WORLFLOW
        tableService.createTable(tableName);
        return new ResponseEntity<>("CREATED", null, HttpStatus.ACCEPTED);
    }
    
    @DeleteMapping("/")
    public ResponseEntity<String> deleteTable(
    @RequestBody String tableName){
        
        try{
        //TYPE ERRORS
        if(!(tableName instanceof String)){
            throw new Error("tableName must be of type String");
        }
        
        //CONTENT ERRORS
        if(tableName.length() < 1){
            throw new Error("tableName must be at least 1 character long");
        }

        }
        catch(Error e){
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.BAD_REQUEST);
        }
                 
        //NORMAL WORLFLOW
        tableService.deleteTable(tableName);
        return new ResponseEntity<>("DELETED", null, HttpStatus.ACCEPTED);
    }
}
